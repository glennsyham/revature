// Checks if a user is already logged in, if yes redirect to homepage
if (!principal) {
    window.location.href = "./index.html";
}
async function reimtype() {


    let response = await fetch(`${apiUrl}/type`, {
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
        var reimType_list = data;
        let reimSelect = document.getElementById('reimb_type_id');
        reimSelect.innerHTML = "";
        let opt = document.createElement('option');
        opt.setAttribute('selected', 'selected');
        opt.innerHTML = "Select a type";
        reimSelect.append(opt);

        for (i in reimType_list) {
            let opt = document.createElement('option');
            opt.setAttribute('value', reimType_list[i].id);
            opt.innerHTML = reimType_list[i].reimb_type;
            reimSelect.append(opt);
        }
    }
}
reimtype();
// Setting up event listener for add button
let addButton = document.getElementById('submitButton');
addButton.addEventListener('click', add);

async function add() {

    let reimb_type_id = document.getElementById('reimb_type_id').value;
    let amount = document.getElementById('amount').value;
    let description = document.getElementById('description').value;
    let author_id = principal.id;
    if (amount < 1 || description == '' || reimb_type_id == '') {
        document.getElementById('message').innerHTML = `<div class="alert alert-danger" role="alert">
        Unable to add. 
    </div>`;
        return false;
    }
    let response = await fetch(`${apiUrl}/reim`, {
        method: 'POST',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: JSON.stringify({
            'reimb_type_id': reimb_type_id,
            'amount': `${amount}`,
            'description': `${description}`,
            'author_id': author_id
        })
    });

    if (response.status == 200) {
        Swal.fire({
            icon: 'success',
            text: 'Succesfully Saved',
            timer: 2000,
        });
        document.getElementById('reimb_type_id').value = '';
        document.getElementById('amount').value = '';
        document.getElementById('description').value = '';
    } else {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Unable to add',
        });
    }
}