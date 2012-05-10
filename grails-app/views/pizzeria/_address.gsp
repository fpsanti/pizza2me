<address>
<strong>${fieldValue(bean: pizzeria, field: "name")}</strong>
<br>
${fieldValue(bean: pizzeria, field: "address.city")}, ${fieldValue(bean: pizzeria, field: "address.province")} ${fieldValue(bean: pizzeria, field: "address.cap")}
<br>
${fieldValue(bean: pizzeria, field: "address.street")}, ${fieldValue(bean: pizzeria, field: "address.number")}
<br>
<abbr title="Phone">Tel:</abbr>
${fieldValue(bean: pizzeria, field: "phone")}
</address>
