<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <meta name="description" content="RSVP">
    <meta name="keywords" content="wedding matt jen vancouver">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="lib/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="lib/bootstrap/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="css/wedding.css">
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="index.html">Jenn and Matt</a>
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class=""><a href="index.html">Home</a></li>
                <li class="active"><a href="#">RSVP</a></li>
            </ul>

        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


            <div class="jumbotron">
                <div class="container">
                    <span style="text-align: center"><h1></h1> </span>
                </div>
            </div>


            <div class="col-sm-10 row  loginDiv">
                <form name="pass" method="post" action="/#" id="pass">

                    <div class="col-sm-9 myInput">
                        <label for="adminPass">Password:</label>
                        <input id="adminPass" class="Input" type="password" name="adminPass" autocorrect="off"
                               autocapitalize="off"
                               placeholder="Password"/>
                        <span class="error hidden">Invalid password </span>
                    </div>
                    <div class="col-sm-9 myInput">
                        <a href="#" class="button btn btn-default" id="submitPass">
                            <span id="submitPassSpan">Login</span>
                        </a>
                    </div>
                </form>
            </div>
            <div class="adminDashboard">
                <div class="col-sm-9 myInput">
                    <a href="#" class="button btn btn-default" id="getAllRSVPs">
                        <span>View/Edit RSVPs</span>
                    </a>
                </div>
                <div class="col-sm-9 myInput">
                    <a href="#" class="button btn btn-default" id="getAllMeals">
                        <span>View/Edit Meal Choices</span>
                    </a>
                </div>

            </div>

            <div class="col-sm-10 adminMeal">

                <div>
                    <table id="tblMeal" class="table table-hover">

                        <thead>
                        <tr>
                            <th>id</th>
                            <th>Name</th>

                        </tr>
                        </thead>

                    </table>

                    <div class="col-sm-9 myInput">
                        <a href="#" class="button btn btn-default" id="addMeal">
                            <span>Add Meal</span>
                        </a>
                    </div>

                </div>
                <div class="row editMealRow">
                    <div class="col-sm-10 ">


                        <form name="mealEdit" method="post" action="/#" id="meal_edit">

                            <div class="col-sm-9 myInput ">
                                <label for="meal_id">ID:</label>
                                <input id="meal_id" class="Input readonly" readonly type="text" name="meal_id"
                                       autocorrect="off"
                                       autocapitalize="off"
                                       placeholder="ID"/>
                            </div>

                            <div class="col-sm-9 myInput ">
                                <label for="meal_name">Name:</label>
                                <input id="meal_name" class="Input " type="text" name="meal_name" autocorrect="off"
                                       autocapitalize="off"
                                       placeholder="Name"/>
                            </div>


                            <div class="col-sm-10">
                                <div class="col-sm-3 myInput adminButton">
                                    <a href="#" class="button btn btn-default" id="submitEditMeal">
                                        <span id="edMeal">Submit Edit</span>
                                    </a>
                                </div>
                                   <div class="col-sm-3 myInput adminButton">
                                    <a href="#" class="button btn btn-default" id="editDeleteMeal">
                                        <span>Delete</span>
                                    </a>
                                </div>
                                <div class="col-sm-3 myInput adminButton">
                                    <a href="#" class="button btn btn-default" id="editCancelMeal">
                                        <span>Cancel</span>
                                    </a>
                                </div>
                            </div>

                        </form>

                    </div>
                </div>

            </div>


            <div class="col-sm-10 adminConsole">

                <div>
                    <table id="tbl" class="table table-hover">

                        <thead>
                        <tr>
                            <th>id</th>
                            <th>first Name</th>
                            <th>Last Name</th>
                            <th>phone Number</th>
                            <th>Email</th>
                            <th>Status</th>
                            <th>Meal</th>
                            <th>Address</th>
                            <th>association</th>
                            <th>Notes</th>
                            <th>Plus One</th>
                            <th>Plus One Meal</th>
                            <th>Edit</th>
                        </tr>
                        </thead>

                    </table>


                </div>

                <div class="row adminEditSingle">

                    <div class="col-sm-10">


                        <form name="signupEdit" method="post" action="/#" id="rsvp_edit">

                            <div class="col-sm-9 myInput ">
                                <label for="id">ID:</label>
                                <input id="id" class="Input readonly" readonly type="text" name="id" autocorrect="off"
                                       autocapitalize="off"
                                       placeholder="ID"/>
                            </div>


                            <div class="col-sm-9 myInput ">
                                <label for="firstName">First Name:</label>
                                <input id="firstName" class="Input" type="text" name="firstName" autocorrect="off"
                                       autocapitalize="off"
                                       placeholder="First Name"/>
                            </div>


                            <div class="col-sm-9 myInput">
                                <label for="lastName">Last Name:</label>
                                <input id="lastName" class="Input" type="text" name="lastName" autocorrect="off"
                                       autocapitalize="off"
                                       placeholder="Last Name"/>
                            </div>


                            <div class="col-sm-9 myInput">
                                <label for="contact">Phone #:</label>
                                <input id="contact" class="Input" type="text" name="contact" autocorrect="off"
                                       autocapitalize="off"
                                       placeholder="Phone Number"/>
                            </div>


                            <div class="col-sm-9 myInput">
                                <label for="address">Address:</label>
                    <textarea id="address" class="form-control" rows="3" name="address" autocorrect="off"
                              autocapitalize="off"
                              placeholder="Address"> </textarea>
                            </div>


                            <div class="col-sm-9 myInput">
                                <label for="email">Email:</label>
                                <input id="email" class="Input" type="email" name="email" autocorrect="off"
                                       autocapitalize="off"
                                       placeholder="Email"/>
                            </div>
                            <div class="col-sm-9 myInput">
                                <label for="association">Guest of:</label>

                                <div class="btn-group" id="associations" role="group" aria-label="...">

                                    <select class="form-control" id="association">
                                        <option id="brideAssoc" val="bride">Bride</option>
                                        <option id="bothAsssoc" val="both">Both</option>
                                        <option id="groomAssoc" val="groom">Groom</option>
                                    </select>
                                </div>

                            </div>


                            <div class="col-sm-9 myInput">
                                <div class="form-group">
                                    <div class="col-sm-9 myInput">
                                        <label for="attendings">Attending:</label>
                                        <select class="form-control" id="attendings">
                                            <option id="yes" val="yes">Yes</option>
                                            <option id="no" val="no">No</option>
                                        </select>


                                    </div>
                                    <label for="menuSel">Menu:</label>
                                    <select class="form-control" id="menuSel">
                                    </select>
                                </div>
                            </div>


                            <div class="col-sm-9 myInput">
                                <label for="plusOne">Plus One:</label>

                                <div class="btn-group" id="plusOne" role="group" aria-label="...">
                                    <button type="button" class="btn btn-default btn-plus" id="plusYes">Yes</button>
                                    <button type="button" class="btn btn-default btn-plus active" id="plusNo">No
                                    </button>
                                </div>
                            </div>


                            <div class="col-sm-9 plusOne">

                                <div class="col-sm-9 myInput ">
                                    <label for="plusOneId">ID:</label>
                                    <input id="plusOneId" class="Input readonly" readonly type="text" name="id"
                                           autocorrect="off" autocapitalize="off"
                                           placeholder="ID"/>
                                </div>

                                <div class="col-sm-9 myInput">
                                    <label for="plusOneName">Plus One Name:</label>
                                    <input id="plusOneName" class="Input" type="text" name="plusOneName"
                                           autocorrect="off" autocapitalize="off"
                                           placeholder="Name"/>
                                </div>

                                <div class="col-sm-9 myInput">
                                    <div class="form-group">
                                        <label for="menuSelPlusOne">Menu:</label>
                                        <select class="form-control" id="menuSelPlusOne">
                                        </select>
                                    </div>
                                </div>
                            </div>


                            <div class="col-sm-9 myInput error">
                                <h2> Please fill out the entire form</h2>
                            </div>

                            <div clas="col-sm-10">

                                <div class="col-sm-3 myInput adminButton">
                                    <a href="#" class="button btn btn-default" id="submitEdit">
                                        <span>Submit Edit</span>
                                    </a>
                                </div>

                                <div class="col-sm-3 myInput adminButton">
                                    <a href="#" class="button btn btn-default" id="editDelete">
                                        <span>Delete Guest</span>
                                    </a>
                                </div>
                                <div class="col-sm-3 myInput adminButton">
                                    <a href="#" class="button btn btn-default" id="editCancel">
                                        <span>Cancel</span>
                                    </a>
                                </div>
                            </div>
                        </form>

                    </div>
                </div>


            </div>

        </div>
    </div>
</div>

<script src="js/rest.js"></script>
<script src="js/admin/dashboard.js"></script>
<script src="js/admin/meal.js"></script>
<script src="js/admin/guest.js"></script>


<script src="js/vendor/jquery-2.1.3.min.js"></script>
<script src="js/vendor/jquery.cookie.js"></script>
<script src="js/vendor/jquery.jsontotable.js"></script>
<script src="lib/bootstrap/js/bootstrap.min.js"></script>
<script src="js/vendor/spin.js"></script>

<script src="js/vendor/jquery.spin.js"></script>
<script>
//    var serverURL = "http://localhost:8080/";
//var serverURL = "http://andybackend-newmansoft.rhcloud.com/rsvp/";
var serverURL ="MattandJenn2015.ca";
    var adminPass;

    var allData;
    var allMeals;
    var allMealMap;

    //$('#customers').tableExport({type:'excel',escape:'false'});

    var getListOnError = function (data) {
        $(".adminConsole").hide();
        $(".error").removeClass('hidden');
    };

    $(document).ready(function () {
        $(".adminDashboard").hide();
        hideAll();
        getListOfMeals(prePopMealList);

        $("#getAllRSVPs").on('click', function () {
                    hideAll();
                    console.log(adminPass);
                    $(".error").addClass('hidden');

       

                    getList();
                }
        );

        $("#getAllMeals").on('click', function () {
            hideAll();
            $(".adminMeal").show();
          $(".adminMeal").spin();
            getListOfMeals(getListOfMealsOnSuccess);
        })
        $("#adminPass").keyup(function (e) {
            if (e.keyCode == 13) {
                event.preventDefault();
                $("#submitPass").click();
            }
        });
        $("#adminPass").keydown(function (e) {
            if (e.keyCode == 13) {
                event.preventDefault();
                $("#submitPass").click();
            }
        });

        $('#addMeal').on('click', function () {
            $('#meal_id').val('');
            $('#meal_name').val('');
            $('.editMealRow').show();

            $('.edMeal').text('Add Meal');
        });

        $('#submitEditMeal').on('click', function () {
            submitEditMeal();
        });

        $("#editCancel").on('click', function () {
            $(".adminEditSingle").hide();
        });
        $("#submitPass").on('click', function (e) {
            adminPass = $("#adminPass").val().trim();

            adminCallAjax(serverURL + "admin/login/", "GET", null, function () {
                $(".adminDashboard").show();
                $(".loginDiv").hide();
            }, function () {
                alert('Invalid Password');
            });


        });



        $("#plusYes").on('click', function (e) {
            e.preventDefault();
            showPlusOne();
            $(".btn-plus").removeClass('active');
            $("#plusYes").addClass('active');
        });
        $("#plusNo").on('click', function (e) {
            e.preventDefault();
            $(".btn-plus").removeClass('active');
            $("#plusNo").addClass('active');
            hidePlusOne();
        });



    });


</script>
<script>
    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
        (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
            m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
    })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

    ga('create', 'UA-58883026-2', 'auto');
    ga('send', 'pageview');

</script>
</body>
</html>
