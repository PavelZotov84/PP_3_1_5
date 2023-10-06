let currentUser = "";

fetch("/api/users/current").then(res => res.json())
    .then(data => {
        currentUser = data;
        console.log(data)
        showOneUser(currentUser);
    })

function showOneUser(user) {
    let temp = "";
    let role = user.roles.map(role => role.name.substring(5));
    temp += "<tr>"
    temp += "<td>" + user.id + "</td>"
    temp += "<td>" + user.firstName + "</td>"
    temp += "<td>" + user.lastName + "</td>"
    temp += "<td>" + user.age + "</td>"
    temp += "<td>" + user.username + "</td>"
    temp += "<td>" + role + "</td>"
    temp += "</tr>"
    document.getElementById("oneUserBody").innerHTML = temp;
    document.getElementById("auth_role").innerHTML = role;
}









