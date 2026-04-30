<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Клієнт</title>
</head>
<body>
<p><a href="/ui/customers">← До списку</a></p>

<#if customer??>
    <h1>${customer.name}</h1>
    <p>Email: ${customer.email}</p>
    <p>Вік: ${customer.age}</p>

    <h2>Створити рахунок</h2>
    <form method="post" action="/ui/customers/${customer.id}/accounts">
        <label>Валюта:
            <select name="currency">
                <#list currencies as currency>
                    <option value="${currency}">${currency}</option>
                </#list>
            </select>
        </label>
        <button type="submit">Додати рахунок</button>
    </form>

    <h2>Рахунки</h2>
    <table border="1" cellpadding="6">
        <tr>
            <th>ID</th>
            <th>Номер</th>
            <th>Баланс</th>
            <th>Валюта</th>
            <th>Дія</th>
        </tr>
        <#list customer.accounts as account>
            <tr>
                <td>${account.id}</td>
                <td>${account.number}</td>
                <td>${account.balance}</td>
                <td>${account.currency}</td>
                <td>
                    <form method="post" action="/ui/customers/${customer.id}/accounts/${account.id}/delete">
                        <button type="submit">Видалити</button>
                    </form>
                </td>
            </tr>
        </#list>
    </table>
<#else>
    <h1>Клієнта не знайдено</h1>
</#if>
</body>
</html>
