#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")/.."
codex '$cote-close'
./scripts/finish-day.sh