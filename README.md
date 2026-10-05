# HackLife 2.0 - Base de microservicios (Java 21 + Spring Boot 3)

Primera iteración con arquitectura base ejecutable para los contextos de HackLife usando módulos Maven independientes y estructura de Clean Architecture.

## Requisitos
- JDK 21
- Maven 3.9+ (o Maven Wrapper si se añade en iteraciones siguientes)
- Docker y Docker Compose
- IntelliJ IDEA (Community o Ultimate)

## Estructura del repositorio
```
.
├── pom.xml
├── docker-compose.yml
├── event-contracts
├── api-gateway
├── auth-user-service
├── habit-streak-service
├── goal-progress-service
├── notification-service
├── gamification-service
└── dashboard-service
```

Cada microservicio incluye `domain`, `application` e `infrastructure`:
- **domain**: entidades y value objects puros (sin Spring/JPA/Lombok)
- **application**: puertos de entrada/salida y casos de uso
- **infrastructure**: controladores REST, entidades JPA, repositorios y configuración Spring

## Límites entre microservicios
- `auth-user-service`: autenticación/autorización, registro y perfiles.
- `habit-streak-service`: hábitos, cumplimiento y cálculo de rachas (primer vertical funcional).
- `goal-progress-service`: objetivos y progreso ligado a hábitos.
- `notification-service`: notificaciones internas persistidas.
- `gamification-service`: puntos, logros y recompensas.
- `dashboard-service`: agregación de métricas de cumplimiento.
- `api-gateway`: capa de entrada y enrutamiento.
- `event-contracts`: contratos de eventos versionables (`HabitCreatedEvent`, `HabitCompletedEvent`).

## Abrir en IntelliJ IDEA
1. **File > Open** y seleccionar la raíz del repositorio.
2. IntelliJ detectará el `pom.xml` padre y cargará todos los módulos.
3. Configurar SDK del proyecto a **Java 21**.
4. Esperar a que Maven sincronice dependencias.

## Infraestructura local (Docker Compose)
Levanta PostgreSQL por servicio y Kafka:
```bash
docker compose up -d
```

Puertos expuestos:
- PostgreSQL auth-user: `5433`
- PostgreSQL habit-streak: `5434`
- PostgreSQL goal-progress: `5435`
- PostgreSQL notification: `5436`
- PostgreSQL gamification: `5437`
- PostgreSQL dashboard: `5438`
- PostgreSQL api-gateway: `5439`
- Kafka: `9092`

## Ejecutar `habit-streak-service`
Desde la raíz:
```bash
mvn -pl habit-streak-service -am spring-boot:run
```

Con perfil explícito de desarrollo:
```bash
mvn -pl habit-streak-service -am spring-boot:run -Dspring-boot.run.profiles=dev
```

URL por defecto: `http://localhost:8082`

### Endpoint de ejemplo
Crear hábito:
```bash
curl -X POST http://localhost:8082/api/v1/habits   -H "Content-Type: application/json"   -d '{
    "userId": "bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb",
    "name": "Caminar 30 minutos",
    "frequency": "DAILY"
  }'
```

## Construcción y pruebas
Compilar y ejecutar pruebas desde raíz:
```bash
mvn test
```

Empaquetar omitiendo pruebas:
```bash
mvn -DskipTests package
```

## Dockerfile (habit-streak-service)
Se incluye `habit-streak-service/Dockerfile` para construir y ejecutar el servicio:
```bash
docker build -t hacklife/habit-streak-service:local -f habit-streak-service/Dockerfile .
docker run --rm -p 8082:8082 --network host hacklife/habit-streak-service:local
```
