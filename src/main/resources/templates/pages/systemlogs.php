<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>GS | System Logs</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="../vendors/ti-icons/css/themify-icons.css">
  <link rel="stylesheet" href="../vendors/base/vendor.bundle.base.css">
  <!-- endinject -->s
  <!-- inject:css -->
  <link rel="stylesheet" href="../css/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="../images/gs-logo.png" />
</head>

<body>
  <div class="container-scroller">
    <!-- partial:../partials/_navbar.html -->
    <?php
    include '../components/navbar.php';
    ?>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
      <!-- partial:../partials/_sidebar.html -->
      <?php include "../components/sidebar.html" ?>
      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
          <div class="row">
            <div class="col-lg-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">System Logs</h4>
                  <p class="card-description">
                    Viewing all system logs
                    <!--Add class <code>.table</code>-->
                  </p>
                  <div class="table-responsive">
                    <table class="table table-hover">
                      <thead>
                        <tr>
                          <th>Log ID</th>
                          <th>User_ID</th>
                          <th>Username</th>
                          <th>Action</th>
                          <th>Details</th>
                          <th>Action time</th>
                        </tr>
                      </thead>
                      <tbody>
                      <?php
                      // URL of the Spring Boot API
                      $url = "http://localhost:8090/api/v1/admin/systemlogs/";
                      $ch = curl_init($url);
                      curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
                      curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/json'));
                      $response = curl_exec($ch);
                      curl_close($ch);
                      $data = json_decode($response, true);
                      if (!empty($data)) {

                        
                          // Iterate over each user
                          foreach ($data as $row) {
                              $id = htmlspecialchars($row["id"]);
                              $action = htmlspecialchars($row["action"]);
                              $createdDateTime = substr(htmlspecialchars($row["timestamp"]), 0, 19);
                              $details = htmlspecialchars($row["details"]);
                              $userId = htmlspecialchars($row["userId"]);
                              
                              //get username
                              $url2 = "http://localhost:8090/api/v1/admin/users/get/$userId";
                              $ch2 = curl_init($url2);
                              curl_setopt($ch2, CURLOPT_RETURNTRANSFER, true);
                              curl_setopt($ch2, CURLOPT_HTTPHEADER, array('Content-Type: application/json'));
                              $response2 = curl_exec($ch2);
                              curl_close($ch2);
                              $data2 = json_decode($response2, true);
                              $username = htmlspecialchars($data2["username"]);

                              echo <<<HTML
                              <tr>
                                <td>$id</td>
                                <td>$userId</td>
                                <td>$username</td>
                                <td>$action</td>
                                <td>$details</td>
                                <td>$createdDateTime</td>
                              </tr>
                              HTML;
                          }
                      } else {
                          echo "<tr><td colspan='6'>No data found</td></tr>";
                      }
                      ?>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- content-wrapper ends -->
        <?php include "../components/footer.php"; ?>
          <script>
            function deleteUser(userId) {
              if (confirm('Are you sure you want to delete this user?')) {
                  fetch(`http://localhost:8090/api/v1/admin/users/delete/${userId}`, {
                      method: 'DELETE'
                  })
                  .then(response => {
                      if (!response.ok) {
                          throw new Error('Network response was not ok');
                      }
                      alert('User deleted successfully');
                      // Optionally, you can refresh the page or update the UI to reflect the deletion
                      location.reload();
                  })
                  .catch(error => {
                      console.error('There was a problem with the fetch operation:', error);
                      alert('Failed to delete user');
                  });
              }
            }
            function updateStatus(userId, currentStatus) {
            // Prompt user for confirmation
            var confirmChange = confirm("Are you sure you want to change the status?");

            if (confirmChange) {
                // Determine the new status
                var newStatus = currentStatus == 1 ? 0 : 1;

                // URL of the Spring Boot API
                var url = `http://localhost:8090/api/v1/admin/users/status/${newStatus}`;

                // Data to be sent in the request body
                var data = JSON.stringify({ id: userId });

                // Create a new request
                var xhr = new XMLHttpRequest();

                // Configure it: PUT-request for the URL
                xhr.open("PUT", url, true);

                // Set the request header for JSON content type
                xhr.setRequestHeader("Content-Type", "application/json");

                // Callback function for when the request completes
                xhr.onload = function () {
                    if (xhr.status >= 200 && xhr.status < 300) {
                        // Parse the JSON response
                        var response = JSON.parse(xhr.responseText);

                        // Alert success message
                        location.reload();
                        alert("Status changed successfully.");

                        // Optionally, you can update the UI or redirect the page
                         // Refresh the page
                    } else {
                        // Handle errors
                        alert("Failed to update status: " + xhr.statusText);
                    }
                };

                // Send the request with the data
                xhr.send(data);
            } else {
                alert("Status change canceled.");
            }
        }
          </script>
      </div>
      <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->
  <!-- plugins:js -->
  <script src="../vendors/base/vendor.bundle.base.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page-->
  <!-- End plugin js for this page-->
  <!-- inject:js -->
  <script src="../js/off-canvas.js"></script>
  <script src="../js/hoverable-collapse.js"></script>
  <script src="../js/template.js"></script>
  <script src="../js/todolist.js"></script>
  <!-- endinject -->
  <!-- Custom js for this page-->
  <!-- End custom js for this page-->
</body>

</html>
