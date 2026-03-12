document.getElementById('loginForm').addEventListener('submit', function(e){
    e.preventDefault();
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    fetch('http://localhost:8080/Canteen_Management/LoginServlet', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ email, password })
    })
    .then(res => res.json())
    .then(data => {
        if(data.success){
            sessionStorage.setItem('student_id', data.student_id);
            alert('Login Successful!');
          window.location.href="home.html";
        } else {
            alert('Invalid credentials!');
        }
    })
    .catch(err => console.error(err));
});