#!/usr/bin/env groovy

def call(Map args) {
  final Double coverageThreshold = args.threshold ?: 80.0
  final Double coverageDeltaThreshold = args.deltaThreshold ?: null
  final String xmlPath = args.xmlPath ?: "cobertura-coverage.xml"

  final lib = new com.spotify.jenkinsfile.Coverage()

  final Double coverage = lib.getCoverageFromCobertura(xmlPath)
  lib.postCoverage(coverage, coverageThreshold)

  final Double coverageDelta = lib.getCoverageDelta()
  lib.postCoverageDelta(coverageDelta, coverageDeltaThreshold)
}
