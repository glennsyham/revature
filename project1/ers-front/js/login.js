// Checks if a user is already logged in, if yes redirect to homepage
if (principal) {
    window.location.href = "./index.html";
}

// Setting up event listener for login button
let loginButton = document.getElementById('submitButton');
loginButton.addEventListener('click', login);

async function login() {

    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;

    document.getElementById('submitButton').style.display = "none";
    document.getElementById('loadButton').style.display = "block";

    let response = await fetch(`${apiUrl}/auth`, {
        method: 'POST',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams({
            'username': `${username}`,
            'password': `${password}`
        })

    });


    if (response.status == 200) {
        let data = await response.json();

        /*
            persisting the User object sent back to session storage for use in other pages
            Session Storage only allows persistence of Strings so the JS Object is converted to a JSON string using JSON.stringify
         */
        document.getElementById('submitButton').style.display = "block";
        document.getElementById('loadButton').style.display = "none";
        sessionStorage.setItem('principal', JSON.stringify(data));
        Swal.fire({
            title: 'Login Success',
            text: 'Redirecting...',
            icon: 'success',
            timer: 2000,
            buttons: false,
        }).then(() => {
            window.location.href = "./index.html";
        });

    } else {
        document.getElementById('submitButton').style.display = "block";
        document.getElementById('loadButton').style.display = "none";
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Login Failed',
        });
    }
}