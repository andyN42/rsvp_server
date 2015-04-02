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
                    <span style="text-align: center"><h1>RSVP</h1> </span>
                </div>
            </div>

            <div id="thanks" class="jumbotron centred">
                <span>Your RSVP Has been Received, Thank you.</span>
            </div>
            <div id="returning" class="jumbotron centred">
                <span>You have already submitted your RSVP. Do you want to update it?</span>

                <div class="showEditBtn">
                    <a href="#" class="button btn btn-default" id="showEditBtn">
                        <span id="reshow"> Edit RSVP</span>
                    </a>
                </div>
            </div>
                       <form name="signup" method="post" action="/#" id="rsvp">

                <div class="col-sm-9 myInput ">
                    <label for="firstName">First Name:</label>
                    <input id="firstName" class="Input" type="text" name="firstName" autocorrect="off" autocapitalize="off"
                           placeholder="First Name"/>
                </div>



                <div class="col-sm-9 myInput" >
                    <label for="lastName">Last Name:</label>
                    <input id="lastName" class="Input" type="text" name="lastName" autocorrect="off" autocapitalize="off"
                           placeholder="Last Name"/>
                </div>


                <div class="col-sm-9 myInput">
                    <label for="contact">Phone #:</label>
                    <input id="contact" class="Input" type="text" name="contact" autocorrect="off" autocapitalize="off"
                           placeholder="Phone Number"/>
                </div>


                <div class="col-sm-6 myInput">
                    <label for="address">Address:</label>
                    <textarea id="address" class="form-control" rows="3" name="address" autocorrect="off" autocapitalize="off"
                              placeholder="Address"> </textarea>
                </div>


                <div class="col-sm-9 myInput">
                    <label for="email">Email:</label>
                    <input id="email" class="Input" type="email" name="email" autocorrect="off" autocapitalize="off"
                           placeholder="Email"/>
                </div>
                <div class="col-sm-9 myInput">
                    <label for="association">Guest of:</label>
                    <div class="btn-group" id="association" role="group" aria-label="...">
                        <button type="button" class="btn btn-default btn-assoc " id="brideAssoc">Bride</button>
                        <button type="button" class="btn btn-default btn-assoc" id="bothAssoc">Both</button>
                        <button type="button" class="btn btn-default btn-assoc" id="groomAssoc">Groom</button>
                    </div>

                </div>


                <div class="col-sm-9 myInput">
                    <label for="attendings">Attending:</label>
                    <div class="btn-group" id="attendings" role="group" aria-label="...">
                        <button type="button" class="btn btn-default btn-attend active" id="yes">Yes</button>
                        <button type="button" class="btn btn-default btn-attend" id="no">No</button>
                    </div>

                </div>
                <div class="col-sm-4 myInput">
                    <div class="form-group">
                        <label for="menuSel">Menu:</label>
                        <select class="form-control" id="menuSel">
                        </select>
                    </div>
                </div>


                <div class="col-sm-9 myInput">
                    <label for="plusOne">Plus One:</label>
                    <div class="btn-group" id="plusOne" role="group" aria-label="...">
                        <button type="button" class="btn btn-default btn-plus" id="plusYes">Yes</button>
                        <button type="button" class="btn btn-default btn-plus active" id="plusNo">No</button>
                    </div>
                </div>


                <div class="col-sm-9 plusOne">
                    <div class="col-sm-9 myInput">
                        <label for="plusOneName">Plus One Name:</label>
                        <input id="plusOneName" class="Input" type="text" name="plusOneName" autocorrect="off" autocapitalize="off"
                               placeholder="Name"/>
                    </div>

                    <div class="col-sm-4 myInput">
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

                <div class="col-sm-9 myInput">
                    <a href="#" class="button btn btn-default" id="submit">
                        <span id="button_submit_text">   Submit</span>
                    </a>
                </div>
            </form>

        </div>
    </div>
</div>

<script src="js/vendor/jquery-2.1.3.min.js"></script>
<script src="js/vendor/jquery.cookie.js"></script>
<script src="lib/bootstrap/js/bootstrap.min.js"></script>
<script src="js/vendor/spin.js"></script>

<script src="js/vendor/jquery.spin.js"></script>
   <script>

//       var serverURL = "http://localhost:8080/";
//var serverURL = "http://andybackend-newmansoft.rhcloud.com/rsvp/";
var serverURL ="MattandJenn2015.ca";

       var attendingStatus = true;
       var plusOneStatus = false;
       var association = 'none-selected';

       var isEdit = false;
       var id;
       var plusOneId;

       var showPlusOne = function () {
        $('.plusOne').show();
       };

       var hidePlusOne = function() {
           $('.plusOne').hide();
       };

       var processForm = function () {


           $('.error').hide();

           var firstName = $('#firstName').val().trim();
           var lastName = $('#lastName').val().trim();
           var email = $('#email').val().trim();
           var contact = $('#contact').val().trim();
           var address = $('#address').val().trim();
           var attending = attendingStatus;
           var menu = $('#menuSel option:selected').attr('id');




           var isValid = true;

           isValid = firstName && lastName && email && contact && address && menu;




           var obj = {
                'firstName' : firstName,
               'lastName': lastName,
               'email' : email,
               'phoneNumber' : contact,
               'address' : address,
               'statusId' : attending?'1':'0',
               'mealId' : menu,
//               'plusOneStatus' : plusOneStatus,
               'notes': '',
               'association' :association
           };



           if (plusOneStatus) {
               var plusOneName = $('#plusOneName').val().trim();
               var meal = $('#menuSelPlusOne option:selected').attr('id');
               var plusOneInfo = {
                   'name' : plusOneName,
                   'mealChoiceId'  : meal
               }
               obj.plusOneInfo = plusOneInfo;
           }



           var onComplete = function(a,b,c) {
               console.log('success');
               $.cookie("com.newmansoft.rsvp.client",a.id);
               id = a.id;
               $("#submit").addClass('disabled');
                  $('#rsvp').spin(false);
               $('#rsvp').hide();
               $('#returning').hide();
               $('#thanks').show();

           }

           var onError = function(a,b,c) {
               console.log('failed');
                  $('#rsvp').spin(false);
           }
           if (isValid) {
               console.log('submitting');
               var verb = "POST";
               var url = serverURL + "guest/";
               if (isEdit) {
                   obj.id = id;
                   verb = "PUT";
                   url = url + id;
                   if(obj.plusOneInfo && plusOneId) {
                    
                   obj.plusOneInfo.id = plusOneId;
                   }
               }
               $.ajax( {
                   url: url,
                   type: verb,
                   data: JSON.stringify(obj),
                   dataType:"json",
                   contentType: 'application/json',
                   success: onComplete,
                   error:onError
               })
           } else {
               $('.error').show();
                  $('#rsvp').spin(false);
           }
           console.log(JSON.stringify(obj));


       };

       $(document).ready(function () {

           $('.error').hide();
           $("#thanks").hide();
           $('#returning').hide();
           hidePlusOne();

           var result = $.cookie("com.newmansoft.rsvp.client");
            if (result) {
                console.log('found  ' + result);
                $("#submit").addClass('disabled');
                $('#rsvp').hide();
                $('#returning').show();
                id = result;

            }


           var mealOnComplete = function (data){
               for(var i = 0; i < data.length; i++) {
                   var obj = data[i];

                   $("#menuSel")
               .append($("<option></option>")
                           .attr("value",obj.id)
                                   .attr("id",obj.id)
                           .text(obj.name));
                   $("#menuSelPlusOne")
                           .append($("<option></option>")
                                   .attr("value",obj.id)
                                   .attr("id",obj.id)
                                   .text(obj.name));


               }
           };

           var mealOnError = function() {

           }
           $.ajax( {
               url: serverURL + "meal/",
               type: "GET",
               dataType:"json",
               contentType: 'application/json',
               success: mealOnComplete,
               error:mealOnError
           })



           $("#yes").on('click', function (e) {
               e.preventDefault();
               attendingStatus = true;
               $(".btn-attend").removeClass('active');
               $("#yes").addClass('active');
           });



           $("#no").on('click', function (e) {
               e.preventDefault();
               attendingStatus = false;
               $(".btn-attend").removeClass('active');
               $("#no").addClass('active');
           });


           $("#plusYes").on('click', function (e) {
               e.preventDefault();
               plusOneStatus = true;
               showPlusOne();
               $(".btn-plus").removeClass('active');
               $("#plusYes").addClass('active');
           });



           $("#plusNo").on('click', function (e) {
               e.preventDefault();
               plusOneStatus = false;
               $(".btn-plus").removeClass('active');
               $("#plusNo").addClass('active');
               hidePlusOne();
           });


           $("#brideAssoc").on('click', function (e) {
               e.preventDefault();
               association = 'bride';
               $(".btn-assoc").removeClass('active');
               $("#brideAssoc").addClass('active');
           });
           $("#bothAssoc").on('click', function (e) {
               e.preventDefault();
               association = 'both';
               $(".btn-assoc").removeClass('active');
               $("#bothAssoc").addClass('active');
           });
           $("#groomAssoc").on('click', function (e) {
               e.preventDefault();
               association = 'groom';
               $(".btn-assoc").removeClass('active');
               $("#groomAssoc").addClass('active');
           });



           $("#submit").on('click', function (e) {
               e.preventDefault();
                $('#rsvp').spin();
              processForm();
           });


           var getOnSuccess = function (data) {


               console.log('need to fill out variables here');

                $('#firstName').val(data.firstName);
               $('#lastName').val(data.lastName);
               $('#email').val(data.email);
               $('#contact').val(data.phoneNumber);
               $('#address').val(data.address);
               if (data.statusId  == 1) {
                   $("#yes").click();
               } else {
                   $("#no").click();
               }
               if (data.association ==="bride") {
                   $('#brideAssoc').click();
               } else if (data.association === "groom") {
                   $('#groomAssoc').click();
               } else {
                   $('#bothAssoc').click();
               }

               $('#menuSel').val( data.mealId );

               if (data.plusOneInfo) {
                   $('#plusYes').click();
                   plusOneId = data.plusOneInfo.id;
                   $('#menuSelPlusOne').val( data.plusOneInfo.mealChoiceId );
                   $('#plusOneName').val(data.plusOneInfo.name);
               }

               $("#submit").removeClass('disabled');
                  $('#rsvp').spin(false);

           };

           var getOnError = function (e) {

               alert('something went wrong retrieving the RSVP info');
                  $('#rsvp').spin(false);
           };

           $('#showEditBtn').on('click', function(e) {
               //show form for edit
               e.preventDefault();
               $('#rsvp').show();
                  $('#rsvp').spin();

               $.ajax( {
                   url: serverURL + "guest/" + id,
                   type: "GET",
                   dataType:"json",
                   contentType: 'application/json',
                   success: getOnSuccess,
                   error:getOnError
               });

               $("#submit").text('Submit Changes');
               isEdit = true;

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
