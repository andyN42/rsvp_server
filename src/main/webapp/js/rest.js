/**
 * Created by andyn on 2/20/2015.
 */


var callAjax = function(url, verb, data, onSuccess, onError) {


    $.ajax({
        url: url,
        type: verb,
        data: JSON.stringify(data),
        dataType: "json",
        contentType: 'application/json',
        success: onSuccess,
        error: onError
    });
};

var adminCallAjax = function(url, verb, data, onSuccess, onError) {


    $.ajax({
        url: url,
        type: verb,
        data: JSON.stringify(data),
        headers: {'Authorization': adminPass},
        dataType: "json",
        contentType: 'application/json',
        success: onSuccess,
        error: onError
    });
}