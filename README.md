# MainAcademyFinalProject

Original task description could be found via:
MainAcademyFinalProject main\README_TASKS.md

## Technology stack:

- Java v8
- TestNG

## How to run project by maven CLI:

Regular sequential run:
```mvn clean test```

Run with parameters:
```mvn clean test -Dbrowser=chrome -Dsuite=testng -Dheight=1920 -Dwidth=1080 -DthreadCount=2```

## For report generation:

### ```mvn allure::serve```