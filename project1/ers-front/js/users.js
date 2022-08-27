// Checks if a user is already logged in, if yes redirect to homepage
if (!principal) {
    window.location.href = "./index.html";
}
async function usersList() {


    let response = await fetch(`${apiUrl}/users`, {
        method: 'GET',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },

    });
    if (response.status == 200) {
        let data = await response.json();

        /*
            persisting the User object sent back to session storage for use in other pages
            Session Storage only allows persistence of Strings so the JS Object is converted to a JSON string using JSON.stringify
         */
        var list = data;
        document.getElementById("waiting").setAttribute('class', 'd-flex justify-content-center d-none');


        tableReim(list);
    } else if (response.status == 404) {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'There was an issue',
        });
    } else if (response.status == 401) {
        Swal.fire({
            icon: 'warning',
            title: 'Oops...',
            text: 'Not Authorized',
        });
    }
}
function start() {
    usersList();
    document.getElementById("btn-return").addEventListener('click', returnTable);
}
function returnTable() {
    document.getElementById("view-return").setAttribute('class', 'col-md-5 mt-5 d-none');
    document.getElementById("reim-table").setAttribute('class', 'table  d-none');
    document.getElementById("users_table").setAttribute('class', 'table  mt-5');
}
start();

function tableReim(list) {

    let x = 1;
    for (i in list) {
        tr = document.createElement('tr');
        td = createTableData(x);
        tr.appendChild(td);
        td = createTableData(list[i].first_name);
        tr.appendChild(td);
        td = createTableData(list[i].last_name);
        tr.appendChild(td);
        td = createTableData(list[i].email);
        tr.appendChild(td);
        td = createTableData(list[i].username);
        tr.appendChild(td);
        td = document.createElement('td');
        td.appendChild(viewButtonReimUser(list[i].id));
        tr.appendChild(td);
        x++;
        document.getElementById('user_body').appendChild(tr);
    }
}
function viewButtonReimUser(id) {
    /* <button type="button" class="btn btn-warning">View</button> */
    let button = document.createElement('button');
    button.setAttribute('class', 'btn btn-warning');
    button.innerHTML = "Reimbursements";
    button.addEventListener('click', reim_user.bind(null, id));
    return button;
}

async function reim_user(id) {


    let response = await fetch(`${apiUrl}/users/${id}/reim`, {
        method: 'GET',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },

    });
    document.getElementById('reim_body').innerHTML = `<tr>
    <td colspan="8">
        <div id="waiting_users" class="d-flex justify-content-center">
            <div class="spinner-border" role="status">
                <span class="visually-hidden">Loading...</span>
            </div>
        </div>
    </td>
</tr>`;
    if (response.status == 200) {
        let data = await response.json();
        let list = data;
        document.getElementById("reim-table").setAttribute('class', 'table');
        document.getElementById("users_table").setAttribute('class', 'table d-none');
        document.getElementById("view-return").setAttribute('class', 'col-md-5 mt-5');

        document.getElementById("waiting_users").setAttribute('class', 'd-flex justify-content-center d-none');
        tableReimUser(list);
    } else if (response.status == 404) {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'There was an issue',
        });
    }
}


function tableReimUser(list) {

    let x = 1;
    for (i in list) {
        let tr = document.createElement('tr');
        createListReimUser(x, list[i], tr);
        x++;
        document.getElementById('reim_body').appendChild(tr);
    }
}

function createListReimUser(x, list, tr) {
    td = createTableData(x);
    tr.appendChild(td);
    td = createTableData(list.submitted.substring(0, 16));
    tr.appendChild(td);
    td = createTableData(list.amount);
    tr.appendChild(td);
    td = createTableData(list.description);
    tr.appendChild(td);
    td = createTableData((list.resolved != null) ? list.resolved.substring(0, 16) : "&nbsp;");
    tr.appendChild(td);
    td = createTableData((list.resolver != null) ? (list.resolver.first_name + " " + list.resolver.last_name) : "&nbsp;");
    tr.appendChild(td);
    td = createTableData(list.reim_status.reimb_status);
    tr.appendChild(td);
    td = createTableData(list.reim_type.reimb_type);
    tr.appendChild(td);
    td = document.createElement('td');
    if (list.reim_status.reimb_status == 'pending') {
        td.appendChild(approveButton(list.id, tr, x));
        td.appendChild(denyButton(list.id, tr, x));
    }
    td.appendChild(viewButton(list.id));
    td.style.width = '20%';
    tr.appendChild(td);
}


function approveButton(id, tr, x) {
    /* <button type="button" class="btn btn-success">Approve</button> */
    let button = document.createElement('button');
    button.setAttribute('class', 'btn btn-success me-1');
    button.innerHTML = "Approve";
    button.addEventListener('click', appoveSendConfirm.bind(null, id, tr, x));
    return button;
}

function denyButton(id, tr, x) {
    /* <button type="button" class="btn btn-danger">Deny</button> */
    let button = document.createElement('button');
    button.setAttribute('class', 'btn btn-danger me-1');
    button.addEventListener('click', denySendConfirm.bind(null, id, tr, x));

    button.innerHTML = "Deny";
    // button.addEventListener('click', test(principal.id));
    return button;
}

function viewButton(id) {
    /* <button type="button" class="btn btn-warning">View</button> */
    let button = document.createElement('button');
    button.setAttribute('class', 'btn btn-warning');
    button.innerHTML = "View";
    button.addEventListener('click', viewSend.bind(null, id));
    return button;
}

function appoveSendConfirm(id, tr, x) {

    Swal.fire({
        title: 'Are you sure?',
        text: "Please confirm if you wish to continue",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes'
    }).then((result) => {
        if (result.isConfirmed) {
            appoveSend(id, tr, x);

        }
    })
}

async function appoveSend(id, tr, x) {
    let response = await fetch(`${apiUrl}/reim/${id}`, {
        method: 'PUT',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: JSON.stringify({
            'user_id': principal.id,
            'status': "approved"
        })
    });

    if (response.status == 200) {
        let data = await response.json();
        let list = data;
        tr.innerHTML = "";
        Swal.fire({
            icon: 'success',
            text: 'Accepted',
        });

        createListReimUser(x, list, tr);
    } else if (response.status == 404) {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'There was an issue',
        });
    } else if (response.status == 401) {
        Swal.fire({
            icon: 'warning',
            title: 'Oops...',
            text: 'Not Authorized',
        });
    } else if (response.status == 409) {
        Swal.fire({
            icon: 'warning',
            title: 'Oops...',
            text: 'Status has already been changed',
        });
    }
}

function denySendConfirm(id, tr, x) {

    Swal.fire({
        title: 'Are you sure?',
        text: "Please confirm if you wish to continue",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes'
    }).then((result) => {
        if (result.isConfirmed) {
            denySend(id, tr, x);

        }
    })
}

async function denySend(id, tr, x) {

    let response = await fetch(`${apiUrl}/reim/${id}`, {
        method: 'PUT',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: JSON.stringify({
            'user_id': principal.id,
            'status': "denied"
        })
    });

    if (response.status == 200) {
        let data = await response.json();
        let list = data;
        tr.innerHTML = "";
        Swal.fire({
            icon: 'success',
            text: 'Denied',
        });

        createListReimUser(x, list, tr);
    } else if (response.status == 404) {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'There was an issue',
        });
    } else if (response.status == 401) {
        Swal.fire({
            icon: 'warning',
            title: 'Oops...',
            text: 'Not Authorized',
        });
    } else if (response.status == 409) {
        Swal.fire({
            icon: 'warning',
            title: 'Oops...',
            text: 'Status has already been changed',
        });
    }
}

async function viewSend(id) {

    let response = await fetch(`${apiUrl}/reim/${id}`, {
        method: 'GET',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        }
    });

    if (response.status == 200) {
        let data = await response.json();
        let list = data;
        let single = document.getElementById('view-single');
        let ul = document.createElement('ul');

        let resolved = (list.resolved != null) ? list.resolved.substring(0, 16) : "&nbsp;";
        let resolver = (list.resolver != null) ? (list.resolver.first_name + " " + list.resolver.last_name) : "&nbsp;"
        let button = document.createElement('button');
        button.setAttribute('class', 'btn btn-primary btn-sm');
        button.addEventListener('click', viewTable);

        button.innerHTML = "Back";

        ul.setAttribute('class', 'list-group list-group-flush');
        single.innerHTML = "";
        ul.innerHTML = `<li class="list-group-item"><span class="btn bg-dark text-white">Amount</span>&nbsp; ${list.amount}</li>` +
            `<li class="list-group-item"><span class="btn bg-dark text-white">Description</span>&nbsp;  ${list.description}</li>` +
            `<li class="list-group-item"><span class="btn bg-dark text-white">Submitted</span>&nbsp;  ${list.submitted.substring(0, 16)}</li>` +
            `<li class="list-group-item"><span class="btn bg-dark text-white">Resolved</span>&nbsp;  ${resolved}</li>` +
            `<li class="list-group-item"><span class="btn bg-dark text-white">Resolver</span>&nbsp;  ${resolver}</li>` +
            `<li class="list-group-item"><span class="btn bg-dark text-white">Status</span>&nbsp;  ${list.reim_status.reimb_status}</li>` +
            `<li class="list-group-item"><span class="btn bg-dark text-white">Type</span>&nbsp;  ${list.reim_type.reimb_type}</li>`;
        single.append(button);

        single.append(ul);

        document.getElementById("reim-table").setAttribute('class', 'table d-none');
        document.getElementById("view-return").setAttribute('class', 'col-md-5 mt-5 d-none');
        document.getElementById("view-single").setAttribute('class', 'col-md-5 mt-5');

    } else if (response.status == 404) {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'There was an issue',
        });
    } else if (response.status == 401) {
        Swal.fire({
            icon: 'warning',
            title: 'Oops...',
            text: 'Not Authorized',
        });
    }
}

function viewTable() {

    document.getElementById("reim-table").setAttribute('class', 'table');
    document.getElementById("view-return").setAttribute('class', 'col-md-5 mt-5');
    document.getElementById("view-single").setAttribute('class', 'col-md-5 mt-5 d-none');
}