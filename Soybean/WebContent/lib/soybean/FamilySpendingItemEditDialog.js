/**
 * Modify a selected row in the jqgrid
 */
var editFamilySpendingItem = function (gridSelector) {
    var selected = $(gridSelector).jqGrid('getGridParam', 'selrow');
    var pams = {
        height: 300,
        width: 350,
        editCaption: "Edit a spending item",
        reloadAfterSubmit: false,
        beforeSubmit: function(data) {
            console.log("to submit:",data);
        }
    };
    if (null != selected) {
        $(gridSelector).jqGrid('editGridRow', selected, pams);
    }
    else {
        console.log("Please select a row!");
    }
};