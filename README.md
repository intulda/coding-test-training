# Coding Test Training System

> 매일 최소 1문제를 시작하고, 반드시 기록으로 남기는 훈련 시스템

---

## 목표

* 코딩테스트를 잘하는 것보다
  매일 시작하고 끝내는 습관을 만드는 것
* 라이브코딩 면접 대비를 위해
  사고 → 구현 → 검증 → 회고 흐름을 반복
* 하루 결과를 기록으로 남겨
  누적 데이터를 기반으로 실력 향상

---

## 시스템 개요

이 저장소는 단순한 문제 풀이 공간이 아니라
다음 세 가지를 자동화한 훈련 시스템이다.

### 1. 시작 유도

* Codex CLI와 Skill 기반 코칭
* 문제 선택부터 접근까지 단계적으로 유도

### 2. 기록 강제

* `journal/YYYY-MM-DD.md` 생성
* 풀이 과정과 실패까지 기록

### 3. 완료 체크

* `status/YYYY-MM-DD.done`
* GitHub Actions가 매시간 확인
* 미완료 시 디스코드 알림

---

## 프로젝트 구조

```text
.
├── .codex/
│   ├── config.toml
│   └── skills/
│       ├── cote-coach/
│       └── cote-close/
│
├── .github/workflows/
│   └── watchdog.yml
│
├── scripts/
│   ├── start-session.sh
│   ├── end-session.sh
│   └── finish-day.sh
│
├── journal/
├── status/
├── src/
└── build.gradle
```

---

## 사용 방법

### 1. 시작

```bash
./scripts/start-session.sh
```

* Codex가 코치 모드로 시작
* 문제 추천 및 풀이 유도

---

### 2. 문제 풀이

* `src/main/java`에 구현
* `src/test/java`로 검증
* Gradle로 테스트 실행

---

### 3. 종료

```bash
./scripts/end-session.sh
```

자동 수행:

* journal 생성 및 정리
* `.done` 파일 생성

---

### 4. 결과 반영

```bash
git add .
git commit -m "feat: daily coding test YYYY-MM-DD"
git push origin main
```

---

## Watchdog 시스템

### 동작 방식

* 매시간 (10:00 ~ 23:00) 실행
* 오늘 `.done` 파일 존재 여부 확인

### 상태별 행동

#### 미완료

디스코드 알림 전송

* 시작 유도
* 경고
* 마감 압박

#### 완료 (push 시 1회)

* 완료 메시지 전송
* journal 내용 요약 포함

---

## Journal 규칙

파일 위치:

```text
journal/YYYY-MM-DD.md
```

형식:

```text
- 문제:
- 유형:
- 첫 접근:
- 막힌 지점:
- 결과:
- 해설 확인 여부:
- 내일 재풀이:
```

### 원칙

* 못 풀었어도 반드시 작성
* 완벽보다 기록이 우선
* 실패도 데이터로 남긴다

---

## 핵심 규칙

### 1. 정답 금지 (초반 20분)

직접 사고 과정을 거치지 않으면 의미가 없다.

### 2. 브루트포스부터 시작

최적화는 이후 단계에서 고려한다.

### 3. 반드시 결과 남기기

코드, journal, done 중 최소 하나는 남긴다.

### 4. 매일 최소 1문제 착수

완주보다 시작이 중요하다.

---

## Codex Skill

### cote-coach

* 문제 추천
* 사고 과정 유도
* 코드 리뷰
* 반례 제시

### cote-close

* journal 작성 유도
* 완료 처리

---

## 설계 철학

이 시스템의 목적은
잘하는 개발자가 아니라

매일 하는 개발자를 만드는 것이다.

---

## 기대 효과

* 코딩테스트 회피 감소
* 라이브코딩 대응력 향상
* 문제 접근 속도 증가
* 실패 패턴 축적 및 개선

---

## 요약

생각하지 않아도 시작할 수 있도록 만들고,
기록과 알림을 통해 지속적으로 수행하도록 설계된 시스템이다.
