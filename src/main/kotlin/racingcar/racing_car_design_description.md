# [STEP 3] 자동차 경주 기능 구현 설명

## 변경이 될 가능성이 있는 도메인

변경이 될 가능성이 높은 도메인은 추상화 및 디자인 패턴 도입

- 자동차 이동 전략
  - 자동차가 움직이는 방식은 변경이 가능함
  - 랜덤 이동 전략, 기본 이동 전략
  - 엔진으로 네이밍
- 자동차 생성
  - 자동차 마다 이동 전략이 다를 수 있으므로 생성하는 로직 분리
- 입력
  - 라운드 수, 자동차 수를 입력하는 방식은 변경이 될 수 있음
  - 콘솔 입력, HTTP 등
- 출력
  - 경기 중인 자동차의 현재 상태를 알려주는 방식은 변경이 될 수 있음
  - 출력 방식과(adapter) 출력(port)의 분리 
  - 콘솔 출력, HTTP, 스트리밍 등  

## 디자인 패턴

다양한 디자인 패턴 적용 실습

- 전략 패턴
- 어댑터 포트 패턴
  - 입력 역할(레이스를 실행하기 위한 상태를 결정)과 출력 역할(레이스의 현재 상태를 전달)이 명확하다고 판단하여 input, output 을 분리한 어댑터 포트 패턴 도입

![관계도](https://user-images.githubusercontent.com/66561524/200694563-ddb8e2aa-fb0d-4797-b2a2-99a187a0d9b1.png)

## TDD

TDD 로 기능 구현

- 단위 테스트
- KoTest