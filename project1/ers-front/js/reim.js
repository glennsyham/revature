// Checks if a user is already logged in, if yes redirect to homepage
if (!principal) {
    window.location.href = "./index.html";
}
async function reimbursement() {

    let response = await fetch(`${apiUrl}/users/${principal.id}/reim`, {
        method: 'GET',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },

    });
    if (response.status == 200) {
        let data = await response.json();
        let list = data;
        document.getElementById("waiting").setAttribute('class', 'd-flex justify-content-center d-none');
        tableReim(list);
    } else if (response.status == 404) {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'There was an issue',
        });
    }
}
reimbursement();
function tableReim(list) {

    let x = 1;
    for (i in list) {
        tr = document.createElement('tr');

        tr.appendChild(createTableData(x));
        tr.appendChild(createTableData(list[i].amount));
        tr.appendChild(createTableData(list[i].description));
        tr.appendChild(createTableData(list[i].submitted.substring(0, 16)));
        tr.appendChild(createTableData((list[i].resolved != null) ? list[i].resolved.substring(0, 16) : "&nbsp;"));
        tr.appendChild(createTableData((list[i].resolver != null) ? (list[i].resolver.first_name + " " + list[i].resolver.last_name) : "&nbsp;"));
        tr.appendChild(createTableData(list[i].reim_status.reimb_status));
        tr.appendChild(createTableData(list[i].reim_type.reimb_type));

        x++;
        document.getElementById('reim_body').appendChild(tr);
    }
}

