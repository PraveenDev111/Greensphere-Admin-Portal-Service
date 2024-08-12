<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $url = 'http://localhost:8090/api/v1/admin/insert';
    
    // Data to be sent in the request body
    $data = array(
        'username' => $_POST['username'],
        'first_name' => $_POST['first_name'],
        'last_name' => $_POST['last_name'],
        'email' => $_POST['email'],
        'password' => $_POST['password'],
        'address' => $_POST['address'],
        'contact_info' => $_POST['contact_info'],
        'status' => ($_POST['statusRadio'] == 'active') ? true : false
    );

    // Initialize cURL session
    $ch = curl_init($url);

    // Set cURL options
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_POST, true);
    curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($data));
    curl_setopt($ch, CURLOPT_HTTPHEADER, array(
        'Content-Type: application/json',
        'Content-Length: ' . strlen(json_encode($data))
    ));

    // Execute cURL request
    $response = curl_exec($ch);

    if (curl_errno($ch)) {
        echo 'Error: ' . curl_error($ch);
    } else {
        $http_code = curl_getinfo($ch, CURLINFO_HTTP_CODE);
        if ($http_code == 200) {
            // Success: Redirect back to the previous page or show a success message
            header("Location: ../pages/CUD-users.php");
            exit();
        } else {
            // Handle HTTP error codes
            echo 'HTTP Error: ' . $http_code;
        }
    }

    // Close cURL session
    curl_close($ch);
    exit();
}
?>
