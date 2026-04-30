<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employers</title>
</head>
<body>

<a href="/ui/customers">← До клієнтів</a>

<h1>Роботодавці</h1>

<table border="1" cellpadding="8">
    <tr>
        <th>ID</th>
        <th>Назва компанії</th>
        <th>Адреса</th>
    </tr>

    <#list employers as employer>
        <tr>
            <td>${employer.id}</td>
            <td>${employer.name}</td>
            <td>${employer.address}</td>
        </tr>
    </#list>
</table>

</body>
</html>