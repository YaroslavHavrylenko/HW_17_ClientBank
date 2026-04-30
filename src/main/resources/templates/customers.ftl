<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Клієнти банку</title>
</head>
<body>
<h1>Клієнти банку</h1>

<h2>Створити нового користувача</h2>
<form method="post" action="/ui/customers">
    <label>Ім'я: <input name="name" required></label><br>
    <label>Email: <input name="email" type="email" required></label><br>
    <label>Вік: <input name="age" type="number" min="1" required></label><br>
    <button type="submit">Створити</button>
</form>

<h2>Список користувачів</h2>
<table border="1" cellpadding="6">
    <tr>
        <th>ID</th>
        <th>Ім'я</th>
        <th>Email</th>
        <th>Вік</th>
        <th>Рахунки</th>
        <th>Дія</th>
    </tr>
    <#list customers as customer>
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.email}</td>
            <td>${customer.age}</td>
            <td>${customer.accounts?size}</td>
            <td><a href="/ui/customers/${customer.id}">Відкрити</a></td>
        </tr>
    </#list>
</table>

<p><a href="/ui/employers">REST: переглянути роботодавців</a></p>
</body>
</html>
