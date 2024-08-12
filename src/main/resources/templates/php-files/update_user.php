<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $userId = $_POST['userId'];
    $firstName = $_POST['firstName'];
    $lastName = $_POST['lastName'];
    $email = $_POST['email'];
    $password = $_POST['password'];
    $address = $_POST['address'];
    $contactInfo = $_POST['contactInfo'];
    $status = $_POST['status'] === 'active';

    // URL of the Spring Boot API for updating the user
    $url = "http://localhost:8090/api/v1/admin/update";

    // Data to be sent in the request body
    $data = json_encode([
        'id' => $userId,
        'first_name' => $firstName,
        'last_name' => $lastName,
        'email' => $email,
        'password' => $password,
        'address' => $address,
        'contact_info' => $contactInfo,
        'status' => $status
    ]);

    // Initialize cURL
    $ch = curl_init($url);

    // Set cURL options
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "PUT");
    curl_setopt($ch, CURLOPT_HTTPHEADER, array(
        'Content-Type: application/json',
        'Content-Length: ' . strlen($data)
    ));
    curl_setopt($ch, CURLOPT_POSTFIELDS, $data);

    // Execute cURL request
    $response = curl_exec($ch);

    // Check for errors
    if ($response === false) {
        echo 'Curl error: ' . curl_error($ch);
        curl_close($ch);
        exit();
    }

    // Decode the response
    $responseDecoded = json_decode($response, true);
    if (isset($responseDecoded['error'])) {
        echo 'Error: ' . $responseDecoded['error'];
    } else {
        echo 'User updated successfully';
    }

    // Close cURL session
    curl_close($ch);

    // Redirect back to the previous page with a success message
    header("Location: ../pages/CUD-users.php?message=User updated successfully");
    exit();
}
?>
