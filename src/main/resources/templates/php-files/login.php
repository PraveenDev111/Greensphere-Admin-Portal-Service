<?php
session_start();

// Dummy admin credentials - replace with your database query
$valid_admin = ['username' => 'admin', 'password' => 'admin123'];

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $username = $_POST['username'];
    $password = $_POST['password'];
    // Check if credentials match
    if ($username === $valid_admin['username'] && $password === $valid_admin['password']) {
        // Set session variables
        $_SESSION['loggedin'] = true;
        $_SESSION['username'] = $username;
        // Redirect to admin dashboard or any protected page
        header('Location: ../pages/home.php');
        exit;
    } else {
        // Store error message in session
        $_SESSION['error'] = 'Invalid username or password!';
        // Redirect back to login page
        header('Location: ../index.php');
        exit;
    }
}
?>
