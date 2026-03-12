document.getElementById('paymentForm').addEventListener('submit', function(e){
    e.preventDefault();

    const method = document.getElementById('method').value;
    const cart = JSON.parse(sessionStorage.getItem('cart')) || [];
    const student_id = sessionStorage.getItem('student_id');

    if(!student_id){
        alert('Please login first!');
        window.location.href = 'login.html';
        return;
    }

    fetch('http://localhost:8080/YourAppName/PaymentServlet', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({ student_id, cart, method })
    })
    .then(res => res.json())
    .then(data => {
        if(data.success){
            alert('Payment Successful!');
            sessionStorage.removeItem('cart');
            window.location.href = 'orders.html';
        } else {
            alert('Payment Failed!');
        }
    })
    .catch(err => console.error(err));
});