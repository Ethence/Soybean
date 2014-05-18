<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/ui-lightness/jquery-ui-1.10.4.css" />
<link rel="stylesheet" href="css/jqgrid/ui.jqgrid.css" />
<script src="lib/jquery/jquery-1.10.2.js"></script>
<script src="lib/jquery/jquery-ui-1.10.4.min.js"></script>
<script src="lib/jqgrid/grid.locale-en.js"></script>
<script src="lib/jqgrid/jquery.jqGrid.min.js"></script>
<style>
    body { font-size: 62.5%; }
    label, input { display:block; }
    input.text { margin-bottom:12px; width:95%; padding: .4em; }
    fieldset { padding:0; border:0; margin-top:40px; }
    .ui-dialog .ui-state-error { padding: .3em; }
</style>
<title>Home</title>
</head>
<body>
<div id="dialog-form" title="Add new spending item">
    <form>
        <fieldset>
            <label for="newSpendingSpender">Spender</label>
            <input type="text" name="newSpendingSpender" id="newSpendingSpender" value="" class="text ui-widget-content ui-corner-all">
            <label for="newSpendingDate">Date</label>
            <input type="text" name="newSpendingDate" id="newSpendingDate" class="text ui-widget-content ui-corner-all">
            <label for="newSpendingAmount">Amount</label>
            <input type="text" name="newSpendingAmount" id="newSpendingAmount" value="" class="text ui-widget-content ui-corner-all">
            <label for="newSpendingDescription">Description</label>
            <input type="text" name="newSpendingDescription" id="newSpendingDescription" value="" class="text ui-widget-content ui-corner-all">
            <label for="newSpendingCategory">Category</label>
            <input type="text" name="newSpendingCategory" id="newSpendingCategory" value="" class="text ui-widget-content ui-corner-all">
            <label for="newSpendingPayMethod">Pay Method</label>
            <input type="text" name="newSpendingPayMethod" id="newSpendingPayMethod" value="" class="text ui-widget-content ui-corner-all">
        </fieldset>
    </form>
</div>

<input type="text" name="date" id="date" />
<hr/>
<table id="spendingTable"></table>
<hr/>
<button id="addBtn">Add</button>
</body>
<script src="lib/soybean/FamilySpendingTable.js"></script>
<script src="lib/soybean/FamilySpendingItemAddDialog.js"></script>
</html>