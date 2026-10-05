# HackLife 2.0 - Microservicios con Clean Architecture homogénea

Repositorio multi-módulo Maven con 6 microservicios de negocio independientes + API Gateway + contratos de eventos.

## Requisitos
- Java 21
- Maven 3.9+
- Docker y Docker Compose
- IntelliJ IDEA

## Estructura objetivo por microservicio
Cada servicio sigue esta estructura:

```text
application/
domain/model/
domain/model/gateway/
domain/usecase/
infrastructure/driver_adapter/
infrastructure/entry_points/
infrastructure/mappers/
```

### Propósito de cada paquete
- `application`: configuración de beans de casos de uso (`AuthConfig`, `HabitConfig`, etc.).
- `domain.model`: entidades y value objects puros de dominio.
- `domain.model.gateway`: puertos de salida del dominio (sin Spring/JPA/Lombok).
- `domain.usecase`: contratos e implementación de casos de uso de entrada.
- `infrastructure.driver_adapter`: JPA entities `*Data`, `*DataJpaRepository` y `*DataGatewayImpl`.
- `infrastructure.entry_points`: controladores REST, DTOs y manejo de errores.
- `infrastructure.mappers`: mapeo dominio <-> persistencia/API.

## Responsabilidades por microservicio

| Microservicio | Entidad principal | Caso de uso principal | Endpoint base |
|---|---|---|---|
| `auth-user-service` | `Usuario` | `RegistrarUsuarioUseCase` | `/api/v1/usuarios` |
| `habit-streak-service` | `Habito` | `CrearHabitoUseCase` | `/api/v1/habitos` |
| `goal-progress-service` | `Objetivo` | `CrearObjetivoUseCase` | `/api/v1/objetivos` |
| `notification-service` | `Notificacion` | `CrearNotificacionUseCase` | `/api/v1/notificaciones` |
| `gamification-service` | `Puntos` | `AsignarPuntosUseCase` | `/api/v1/puntos` |
| `dashboard-service` | `Metrica` | `RegistrarMetricaUseCase` | `/api/v1/metricas` |

Cada servicio mantiene su propio modelo JPA y sus propias tablas (sin compartir entidades JPA entre servicios).

## Abrir en IntelliJ IDEA
1. **File > Open** y seleccionar `/home/runner/work/hacklife-2.0/hacklife-2.0`.
2. Importar como proyecto Maven desde el `pom.xml` raíz.
3. Configurar SDK del proyecto a **Java 21**.
4. Esperar sincronización de dependencias y módulos.

## Levantar PostgreSQL + Kafka con Docker Compose
Desde la raíz del repositorio:

```bash
docker compose up -d
```

Servicios de infraestructura:
- `postgres-auth-user` -> `auth_user_db` (puerto `5433`)
- `postgres-habit-streak` -> `habit_streak_db` (puerto `5434`)
- `postgres-goal-progress` -> `goal_progress_db` (puerto `5435`)
- `postgres-notification` -> `notification_db` (puerto `5436`)
- `postgres-gamification` -> `gamification_db` (puerto `5437`)
- `postgres-dashboard` -> `dashboard_db` (puerto `5438`)
- `kafka` -> puerto `9092`

## Ejecutar los seis microservicios
Desde la raíz (en terminales separadas):

```bash
mvn -pl auth-user-service -am spring-boot:run
mvn -pl habit-streak-service -am spring-boot:run
mvn -pl goal-progress-service -am spring-boot:run
mvn -pl notification-service -am spring-boot:run
mvn -pl gamification-service -am spring-boot:run
mvn -pl dashboard-service -am spring-boot:run
```

Puertos por defecto:
- auth-user: `8081`
- habit-streak: `8082`
- goal-progress: `8083`
- notification: `8084`
- gamification: `8085`
- dashboard: `8086`

## Pruebas y empaquetado
- Pruebas por módulo:
  ```bash
  mvn -pl <modulo> test
  ```
- Pruebas desde raíz:
  ```bash
  mvn test
  ```
- Empaquetado:
  ```bash
  mvn package
  ```
