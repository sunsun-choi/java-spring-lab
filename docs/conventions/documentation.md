# 문서 관리 규칙

## 문서 위치

```text
java-spring-lab
├─ src
├─ sql
├─ docs
│  ├─ conventions
│  │  └─ documentation.md
│  ├─ notes
│  └─ troubleshooting  
├─ README.md
└─ pom.xml
```

## 구분 기준

| 위치                     | 작성 내용                |
| ---------------------- | -------------------- |
| `docs/notes`           | 프로젝트를 진행하며 새로 학습한 개념 |
| `docs/troubleshooting` | 오류의 원인과 해결 과정        |
| `docs/conventions`     | 프로젝트에서 확정하여 적용하는 규칙  |
| `README.md`            | 프로젝트 전체 안내와 세부 문서 링크 |

## 작성 원칙

* 프로젝트와 직접 관련된 학습 내용은 `docs/notes`에 기록한다.
* 오류 해결 과정은 재현 조건, 원인, 해결 방법을 중심으로 기록한다.
* 프로젝트에서 계속 적용할 결정은 `docs/conventions`에 기록한다.
* 개인 학습 노트는 이해하기 편한 형식으로 자유롭게 작성한다.
* 확정된 규칙과 외부에 공개되는 문서는 명확한 표현으로 정리한다.


