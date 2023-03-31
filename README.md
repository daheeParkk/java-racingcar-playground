## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```
---
## calculator 구현 목록
> - 쉼표,콜론을 구분자로 덧셈하는 기능
> - 커스텀 구분자로 덧셈하는 기능
> - 숫자 하나를 전달하는 경우 -> 해당 숫자 반환
> - 빈 문자열을 전달하는 경우 -> 0 반환
> - 숫자 이외의 값 또는 음수를 전달하는 경우 -> 예외발생
---
# 자동차 경주 게임 
>### < 패키지 >
> - __domain__
>  - Car 
>  - RacingCars 
> ---
> - __controller__
>  - GameController
> ---
> - __service__
>  - RacingService
>  - CarService
> - ---
> - __view__
>  - InputView
>  - ResultView
> - ---

>### < 구현 목록 > 
> - GameController
> - [ ] 게임 시작 기능
> - ---
> - RacingService
> - [ ] 난수를 생성하는 기능 
> - [x] 전진 조건을 확인하는 기능
> - ---
> - CarService
> - [x] 전달받은 차의 수만큼 차를 생성하는 기능
> - [ ] 자동차 위치의 최댓값을 찾는 기능
> - ---
> - RacingCars
> - [x] 위치를 변경하는 기능
> - [x] 위치를 반환하는 기능
> - ---
> - InputView
> - [ ] 자동차들을 입력받는 기능
> - [ ] racing 횟수를 입력받는 기능
> - ---
> - ResultView
> - [ ] 실행 결과를 출력하는 기능
> - [ ] 우승한 자동차를 출력하는 기능 
> - ---
> - __예외처리__
> - [ ] 자동차 이름이 5자를 초과할 경우
> - [ ] 자동차 이름이 중복일 경우
> - [ ] 자동차가 하나일 경우