<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Greensphere Admin</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="../vendors/ti-icons/css/themify-icons.css">
  <link rel="stylesheet" href="../vendors/base/vendor.bundle.base.css">
  <!-- endinject -->
  <!-- plugin css for this page -->
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="../css/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="../images/gs-logo-.png"  type="image/png"/>
</head>

<body>
  <div class="container-scroller">
    <!-- partial:partials/_navbar.html -->
    <?php
    require '../components/navbar.php';
    ?>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
      <!-- partial:partials/_sidebar.html -->
      <?php include "../components/sidebar.html" ?>
      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
          <div class="row">
            <div class="col-md-12 grid-margin">
              <div class="d-flex justify-content-between align-items-center">
                <div>
                  <h4 class="font-weight-bold mb-0">Greensphere Admin Dashboard</h4>
                </div>
                <div>
                  <button type="button" class="btn btn-primary btn-icon-text btn-rounded">
                    <i class="ti-clipboard btn-icon-prepend"></i>Report
                  </button>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-3 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <p class="card-title text-md-center text-xl-left">Turnover</p>
                  <div
                    class="d-flex flex-wrap justify-content-between justify-content-md-center justify-content-xl-between align-items-center">
                    <h3 class="mb-0 mb-md-2 mb-xl-0 order-md-1 order-xl-0">$34,040</h3>
                    <i class="ti-calendar icon-md text-muted mb-0 mb-md-3 mb-xl-0"></i>
                  </div>
                  <p class="mb-0 mt-2 text-success">78% <span class="text-black ms-1"><small>This month</small></span>
                  </p>
                </div>
              </div>
            </div>
            <div class="col-md-3 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <p class="card-title text-md-center text-xl-left">Fines</p>
                  <div
                    class="d-flex flex-wrap justify-content-between justify-content-md-center justify-content-xl-between align-items-center">
                    <h3 class="mb-0 mb-md-2 mb-xl-0 order-md-1 order-xl-0">$800</h3>
                    <i class="ti-agenda icon-md text-muted mb-0 mb-md-3 mb-xl-0"></i>
                  </div>
                  <p class="mb-0 mt-2 text-danger">64.00%<span class="text-black ms-1"><small>Pending payment</small></span>
                  </p>
                </div>
              </div>
            </div>
            <div class="col-md-3 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <p class="card-title text-md-center text-xl-left">Registered Users</p>
                  <div
                    class="d-flex flex-wrap justify-content-between justify-content-md-center justify-content-xl-between align-items-center">
                    <h3 class="mb-0 mb-md-2 mb-xl-0 order-md-1 order-xl-0" id="total-users">...</h3>
                    <i class="fas fa-users icon-md text-muted mb-0 mb-md-3 mb-xl-0"></i>
                  </div>
                  <p class="mb-0 mt-2 text-success" id="active-percentage">0.00% <span class="text-black ms-1"><small>Active</small></span></p>
                  </p>
                </div>
              </div>
            </div>
            <div class="col-md-3 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <p class="card-title text-md-center text-xl-left">Admin accounts</p>
                  <div
                    class="d-flex flex-wrap justify-content-between justify-content-md-center justify-content-xl-between align-items-center">
                    <h3 class="mb-0 mb-md-2 mb-xl-0 order-md-1 order-xl-0" id="total-admin-users">...</h3>
                    <i class="fas fa-user-shield icon-md text-muted mb-0 mb-md-3 mb-xl-0"></i>
                  </div>
                  <p class="mb-0 mt-2 text-danger" id="admin-percentage">0.00%<span class="text-black ms-1"><small>Enabled</small></span>
                  </p>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-6 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <p class="card-title">Garbage categories</p>
                  <p class="text-muted font-weight-light">Received overcame oh sensible so at an. Formed do change
                    merely to county it. Am separate contempt domestic to to oh. On relation my so addition branched.
                  </p>
                  <div id="sales-legend" class="chartjs-legend mt-4 mb-2"></div>
                  <canvas id="sales-chart"></canvas>
                </div>
                <div class="card border-right-0 border-left-0 border-bottom-0">
                  <div class="d-flex justify-content-center justify-content-md-end">
                    <div class="dropdown flex-md-grow-1 flex-xl-grow-0">
                      <button
                        class="btn btn-lg btn-outline-light dropdown-toggle rounded-0 border-top-0 border-bottom-0"
                        type="button" id="dropdownMenuDate2" data-bs-toggle="dropdown" aria-haspopup="true"
                        aria-expanded="true">
                        Today
                      </button>
                      <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuDate2">
                        <a class="dropdown-item" href="#">January - March</a>
                        <a class="dropdown-item" href="#">March - June</a>
                        <a class="dropdown-item" href="#">June - August</a>
                        <a class="dropdown-item" href="#">August - November</a>
                      </div>
                    </div>
                    <button class="btn btn-lg btn-outline-light text-primary rounded-0 border-0 d-none d-md-block"
                      type="button"> View all </button>
                  </div>
                </div>
              </div>
            </div>
            <?php
              // Set the URL of the health endpoint
              $healthUrl = "http://localhost:8090/actuator/health";
              $ch = curl_init();
              curl_setopt($ch, CURLOPT_URL, $healthUrl);
              curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
              curl_setopt($ch, CURLOPT_TIMEOUT, 10);
              $response = curl_exec($ch);

              if ($response === false) {
                  $error = curl_error($ch);
                  curl_close($ch);
                  $dbstatus = 'Error: Timeout';
              } else {
                  curl_close($ch);
                  $data = json_decode($response, true);
                  if (isset($data['status'])) {
                      $dbstatus = ($data['status'] === 'UP') ? 'Connected' : 'DOWN';
                  } else {
                      $dbstatus = 'Invalid response format';
                  }
              }
              ?>
            <div class="col-md-6 grid-margin stretch-card">
              <div class="card border-bottom-0">
                <div class="card-body pb-0">
                <p class="card-title">DB Health monitor</p>
                  <p class="text-muted font-weight-light">Maintain a healthy DB and monitor your DB. Check for any anomallies or excess executions in the last 24-hour</p>
                  <div class="d-flex flex-wrap mb-5">
                    <div class="me-5 mt-3">
                      <p class="text-muted">DB Actuator Health</p>
                      <h3 id="db-status"><?php echo $dbstatus ?></h3>
                    </div>
                    <div class="me-5 mt-3">
                      <p class="text-muted">All users</p>
                      <h3 id="all-users">...</h3>
                    </div>
                    <div class="me-5 mt-3">
                      <p class="text-muted">Disposal records</p>
                      <h3 id="disposal-value">...</h3>
                    </div>
                    <div class="mt-3">
                      <p class="text-muted">Executions on DB /24hr</p>
                      <h3 id="executions-value">...</h3>
                    </div>
                  </div>
                </div>
                <canvas id="order-chart" class="w-100"></canvas>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-7 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <p class="card-title mb-0">Top Products</p>
                  <div class="table-responsive">
                    <table class="table table-hover">
                      <thead>
                        <tr>
                          <th>User</th>
                          <th>Product</th>
                          <th>Sale</th>
                          <th>Status</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>Jacob</td>
                          <td>Photoshop</td>
                          <td class="text-danger"> 28.76% <i class="ti-arrow-down"></i></td>
                          <td><label class="badge badge-danger">Pending</label></td>
                        </tr>
                        <tr>
                          <td>Messsy</td>
                          <td>Flash</td>
                          <td class="text-danger"> 21.06% <i class="ti-arrow-down"></i></td>
                          <td><label class="badge badge-warning">In progress</label></td>
                        </tr>
                        <tr>
                          <td>John</td>
                          <td>Premier</td>
                          <td class="text-danger"> 35.00% <i class="ti-arrow-down"></i></td>
                          <td><label class="badge badge-info">Fixed</label></td>
                        </tr>
                        <tr>
                          <td>Peter</td>
                          <td>After effects</td>
                          <td class="text-success"> 82.00% <i class="ti-arrow-up"></i></td>
                          <td><label class="badge badge-success">Completed</label></td>
                        </tr>
                        <tr>
                          <td>Dave</td>
                          <td>53275535</td>
                          <td class="text-success"> 98.05% <i class="ti-arrow-up"></i></td>
                          <td><label class="badge badge-warning">In progress</label></td>
                        </tr>
                        <tr>
                          <td>Messsy</td>
                          <td>Flash</td>
                          <td class="text-danger"> 21.06% <i class="ti-arrow-down"></i></td>
                          <td><label class="badge badge-info">Fixed</label></td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-5 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">To Do Lists</h4>
                  <div class="list-wrapper pt-2">
                    <ul class="d-flex flex-column-reverse todo-list todo-list-custom">
                      <li>
                        <div class="form-check form-check-flat">
                          <label class="form-check-label">
                            <input class="checkbox" type="checkbox">
                            Become A Travel Pro In One Easy Lesson
                          </label>
                        </div>
                        <i class="remove ti-trash"></i>
                      </li>
                      <li class="completed">
                        <div class="form-check form-check-flat">
                          <label class="form-check-label">
                            <input class="checkbox" type="checkbox" checked>
                            See The Unmatched Beauty Of The Great Lakes
                          </label>
                        </div>
                        <i class="remove ti-trash"></i>
                      </li>
                      <li>
                        <div class="form-check form-check-flat">
                          <label class="form-check-label">
                            <input class="checkbox" type="checkbox">
                            Copper Canyon
                          </label>
                        </div>
                        <i class="remove ti-trash"></i>
                      </li>
                      <li class="completed">
                        <div class="form-check form-check-flat">
                          <label class="form-check-label">
                            <input class="checkbox" type="checkbox" checked>
                            Top Things To See During A Holiday In Hong Kong
                          </label>
                        </div>
                        <i class="remove ti-trash"></i>
                      </li>
                      <li>
                        <div class="form-check form-check-flat">
                          <label class="form-check-label">
                            <input class="checkbox" type="checkbox">
                            Travelagent India
                          </label>
                        </div>
                        <i class="remove ti-trash"></i>
                      </li>
                    </ul>
                  </div>
                  <div class="add-items d-flex mb-0 mt-4">
                    <input type="text" class="form-control todo-list-input me-2" placeholder="Add new task">
                    <button class="add btn btn-icon text-primary todo-list-add-btn bg-transparent"><i
                        class="ti-location-arrow"></i></button>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-12 grid-margin stretch-card">
              <div class="card position-relative">
                <div class="card-body">
                  <p class="card-title">Detailed Reports</p>
                  <div class="row">
                    <div class="col-md-12 col-xl-3 d-flex flex-column justify-content-center">
                      <div class="ml-xl-4">
                        <h1>33500</h1>
                        <h3 class="font-weight-light mb-xl-4">Sales</h3>
                        <p class="text-muted mb-2 mb-xl-0">The total number of sessions within the date range. It is the
                          period time a user is actively engaged with your website, page or app, etc</p>
                      </div>
                    </div>
                    <div class="col-md-12 col-xl-9">
                      <div class="row">
                        <div class="col-md-6 mt-3 col-xl-5">
                          <canvas id="north-america-chart"></canvas>
                          <div id="north-america-legend"></div>
                        </div>
                        <div class="col-md-6 col-xl-7">
                          <div class="table-responsive mb-3 mb-md-0">
                            <table class="table table-borderless report-table">
                              <tr>
                                <td class="text-muted">Illinois</td>
                                <td class="w-100 px-0">
                                  <div class="progress progress-md mx-4">
                                    <div class="progress-bar bg-primary" role="progressbar" style="width: 70%"
                                      aria-valuenow="70" aria-valuemin="0" aria-valuemax="100"></div>
                                  </div>
                                </td>
                                <td>
                                  <h5 class="font-weight-bold mb-0">524</h5>
                                </td>
                              </tr>
                              <tr>
                                <td class="text-muted">Washington</td>
                                <td class="w-100 px-0">
                                  <div class="progress progress-md mx-4">
                                    <div class="progress-bar bg-primary" role="progressbar" style="width: 30%"
                                      aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
                                  </div>
                                </td>
                                <td>
                                  <h5 class="font-weight-bold mb-0">722</h5>
                                </td>
                              </tr>
                              <tr>
                                <td class="text-muted">Mississippi</td>
                                <td class="w-100 px-0">
                                  <div class="progress progress-md mx-4">
                                    <div class="progress-bar bg-primary" role="progressbar" style="width: 95%"
                                      aria-valuenow="95" aria-valuemin="0" aria-valuemax="100"></div>
                                  </div>
                                </td>
                                <td>
                                  <h5 class="font-weight-bold mb-0">173</h5>
                                </td>
                              </tr>
                              <tr>
                                <td class="text-muted">California</td>
                                <td class="w-100 px-0">
                                  <div class="progress progress-md mx-4">
                                    <div class="progress-bar bg-primary" role="progressbar" style="width: 60%"
                                      aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"></div>
                                  </div>
                                </td>
                                <td>
                                  <h5 class="font-weight-bold mb-0">945</h5>
                                </td>
                              </tr>
                              <tr>
                                <td class="text-muted">Maryland</td>
                                <td class="w-100 px-0">
                                  <div class="progress progress-md mx-4">
                                    <div class="progress-bar bg-primary" role="progressbar" style="width: 40%"
                                      aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"></div>
                                  </div>
                                </td>
                                <td>
                                  <h5 class="font-weight-bold mb-0">553</h5>
                                </td>
                              </tr>
                              <tr>
                                <td class="text-muted">Alaska</td>
                                <td class="w-100 px-0">
                                  <div class="progress progress-md mx-4">
                                    <div class="progress-bar bg-primary" role="progressbar" style="width: 75%"
                                      aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
                                  </div>
                                </td>
                                <td>
                                  <h5 class="font-weight-bold mb-0">912</h5>
                                </td>
                              </tr>
                            </table>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- content-wrapper ends -->
        <!-- partial:partials/_footer.html -->
        <?php 
        include '../components/footer.php';
        ?>
        <!-- partial -->
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
  <script src="../vendors/chart.js/Chart.min.js"></script>
  <script src="../js/jquery.cookie.js" type="text/javascript"></script>
  <!-- End plugin js for this page-->
  <!-- inject:js -->
  <script src="../js/off-canvas.js"></script>
  <script src="../js/hoverable-collapse.js"></script>
  <script src="../js/template.js"></script>
  <script src="../js/todolist.js"></script>
  <!-- endinject -->
  <!-- Custom js for this page-->
  <script>
document.addEventListener('DOMContentLoaded', function() {
    fetch("http://localhost:8090/api/v1/admin/allusers")
        .then(response => response.json())
        .then(data => {
            // Calculate the total number of users
            const totalUsers = data.length;
            // Number of active users
            const activeUsers = data.filter(user => user.status === true).length;
            const inactiveUsers = data.filter(user => user.status === false).length;
            const activePercentage = ((activeUsers / totalUsers) * 100).toFixed(2);
            const inactivePercentage = ((inactiveUsers / totalUsers) * 100).toFixed(2);
            // Update the HTML content with the total number of users
            //document.getElementById('active-percentage').innerHTML = `${activePercentage}% <span class="text-black ms-1"><small>Active users</small></span>`;
            document.getElementById('admin-percentage').innerHTML = `${inactivePercentage}% <span class="text-black ms-1"><small>Disabled</small></span>`;
            //document.getElementById('inactive-users').textContent = inactiveUsers;
            animateCounter('total-admin-users', totalUsers);
            animateCounter('all-users', 490);
            animateCounter('total-users', 490);
            animateCounter('inactive-users', inactiveUsers);
            animateCounter('disposal-value', 520);
            animateCounter('executions-value', 109020);
            
            // Fetch the database health status
            
        })
        .catch(error => {
            console.error('Error:', error);
        });
}); 
  function animateCounter(elementId, endValue) {
    const element = document.getElementById(elementId);
    let startValue = 0;
    const duration = 2000; // Duration of the animation in milliseconds
    const increment = Math.ceil(endValue / (duration / 20)); // Increment based on the duration and refresh rate (20ms)

    const counter = setInterval(() => {
      startValue += increment;
      if (startValue >= endValue) {
        startValue = endValue;
        clearInterval(counter);
      }
      element.textContent = startValue;
    }, 20); // Update the counter every 20ms
  }

  </script>
  <script src="../js/dashboard.js"></script>
  <!-- End custom js for this page-->
</body>

</html>