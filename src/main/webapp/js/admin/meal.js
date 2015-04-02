/**
 * Created by andyn on 2/20/2015.
 */
var getListOfMealsOnSuccess = function (data) {


    allMeals = data;

    $(".tbdyMeal").remove();
    var body = $('<tbody class="tbdyMeal"></tbody>');

    $.each(data, function (i, item) {


        var rowStr = '<tr>' +

            '<td>' + item.id + '</td>' +
            '<td>' + item.name + '</td>' +
            '<td> <a href="#" class="editIconMeal" id="edit_meal_' + item.id + '" ><img src="src/img/edit.png"/> </a></td>' +
            '</row>';
        var row = $(rowStr);
        body.append(row);


    });
    $("#tblMeal").append(body);
    $(".editIconMeal").on('click', function (event) {
        event.preventDefault();
        var elem = $(event.target);
        console.log(elem);

        var id = $(event.target).parent('a').attr('id').substring(10);
        showMealDataFor(id);

        $("#submitMealEdit").on('click', submitEditMeal);

    });

    $(".adminMeal").spin(false);
};

var showMealDataFor = function (id) {

    var meal = allMealMap[id];
    if (meal) {

        $('#meal_id').val(id);
        $('#meal_name').val(meal);


        $('.editMealRow').show();
        $('.edMeal').text('Edit Meal');
    }
}
var submitEditMeal = function () {
    $(".editMealRow").spin();
    var id = $('#meal_id').val().trim();
    var name = $('#meal_name').val().trim();
    var obj = {
        'id': id,
        'name': name
    }
    var url = serverURL + "admin/meal/";
    var verb = "POST";
    if (id) {
        verb = "PUT";
        url = url + id;
    }

    var onSuccess = function () {
        $(".editMealRow").spin(false);
        $(".editMealRow").hide();
        getListOfMeals(getListOfMealsOnSuccess, getListOnError);
    }
    adminCallAjax(url, verb, obj, onSuccess, null);

}

var getListOfMeals = function (onSuccess, onError) {
    callAjax(serverURL + "meal/", "GET", null, onSuccess, onError);
};

var prePopMealList = function (data) {

    allMeals = data;
    allMealMap = {};
    for (var i = 0; i < data.length; i++) {
        var obj = data[i];

        allMealMap[obj.id] = (obj.name);

    }
    console.log('check here');
};
var getMealName = function (mealId) {
    if (!allMealMap || !mealId) {
        return '';
    }
    return allMealMap[mealId];

};

var populateMealDropdownFromAllMeals = function (dropdownId){


    for(var i = 0; i < allMeals.length; i++) {
        var obj = allMeals[i];

        $(dropdownId)
            .append($("<option></option>")
                .attr("value",obj.id)
                .attr("id",obj.id)
                .text(obj.name));
    }
};


