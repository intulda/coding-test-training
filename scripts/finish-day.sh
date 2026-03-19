#!/usr/bin/env bash
set -euo pipefail

TODAY=$(TZ=Asia/Seoul date +'%Y-%m-%d')

mkdir -p journal status

if [ ! -f "journal/$TODAY.md" ]; then
  cat > "journal/$TODAY.md" <<EOF
# $TODAY

- 문제:
- 유형:
- 첫 접근:
- 막힌 지점:
- 결과: 성공 / 실패 / 부분성공
- 해설 확인 여부:
- 내일 재풀이:
EOF
fi

touch "status/$TODAY.done"

echo "완료 처리됨:"
echo "- journal/$TODAY.md"
echo "- status/$TODAY.done"