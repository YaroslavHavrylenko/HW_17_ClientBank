# HW 17 ClientBank — виконані зміни

## Що додано/виправлено

1. Додано ORM-мапінг Hibernate/JPA для сутностей `Customer`, `Account`, `Employer`.
2. Створено базовий абстрактний клас `AbstractEntity`, у який винесено поле `id`.
3. Для `Customer` ↔ `Employer` використано зв'язок `ManyToMany`, бо один клієнт може працювати у кількох компаніях, а одна компанія може мати багато клієнтів.
4. Для `Customer` → `Account` використано `OneToMany` з `cascade = CascadeType.ALL` та `orphanRemoval = true`, тому при видаленні клієнта автоматично видаляються його рахунки.
5. Виправлено `EmployerRepository`: тепер він працює із сутністю `Employer`, а не `Customer`.
6. Додано `EmployerController`, `EmployerService`, `EmployerDao`.
7. Видалено ручну генерацію `id` з legacy DAO-класів; генерацію виконує база даних через `GenerationType.IDENTITY`.
8. Налаштовано профілі:
   - `local` — активний за замовчуванням, H2 in-memory database;
   - `prod` — підключення до MySQL через environment variables.
9. Додано `data.sql` для автоматичного наповнення H2 тестовими клієнтами, компаніями, зв'язками та рахунками.
10. Додано простий UI на FreeMarker:
    - `/ui/customers` — список клієнтів і форма створення клієнта;
    - `/ui/customers/{id}` — рахунки клієнта, створення і видалення рахунків.

## Запуск local-профілю

```bash
./mvnw spring-boot:run
```

Після запуску:

- UI: `http://localhost:9000/ui/customers`
- REST customers: `http://localhost:9000/customers`
- REST employers: `http://localhost:9000/employers`
- H2 Console: `http://localhost:9000/h2-console`

Параметри H2:

- JDBC URL: `jdbc:h2:mem:clientbankdb`
- User: `sa`
- Password: порожній

## Запуск prod-профілю

```bash
PROD_DB_URL=jdbc:mysql://host:3306/clientbank \
PROD_DB_USERNAME=user \
PROD_DB_PASSWORD=password \
./mvnw spring-boot:run -Dspring-boot.run.profiles=prod
```

Або через JVM параметр:

```bash
./mvnw spring-boot:run -Dspring-boot.run.arguments=--spring.profiles.active=prod
```
