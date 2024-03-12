# Getting Started

### Package
```agsl
./gradlew clean build
```

### Server Start

```sql
nohup java -jar sprint-boot-hikariCP-0.0.1-SNAPSHOT.jar > output.log 2>&1 &
```

### API Call

```sql
curl localhost:8080/test
```

### Simulate Writer IO Stuck
```sql
ALTER SYSTEM SIMULATE 100 PERCENT DISK FAILURE FOR INTERVAL 5 MINUTE;
```

### Find the log error message

```sql
tail -f output.log
```