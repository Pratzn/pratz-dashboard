<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pop-up Dialog</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<style type="text/css">

/* ------------------------------------------------------------
    HTML, Body, Anchor,etc.
   ------------------------------------------------------------ */
html {
	color: #000;
	background: #EEEEEE;
	height: 100%;
}

body {
	margin: 0;
	padding: 0;
	height: 0%;
	font-family: Arial, sans-serif;
	line-height: 1.5em;
	font-size: 12px;
	/* text-align: center; */
	line-height: 1.5em;
}

div.customer-card-entry {
	margin-left: 20px;
	margin-top: 20px;
}

div.asset-entry {
	margin-left: 20px;
	margin-top: 20px;
	width: 80%;
}

div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, code, form,
	fieldset, legend, input, textarea, p, blockquote, th, td {
	margin: 0;
	padding: 0;
}

textarea {
	width: 100%
}

.button-popup {
	clear: both;
	height: 20px;
	float: none;
	margin: 0;
	padding: 0;
	text-align: left;
}

ul {
	list-style-type: none;
}

input[type="file"] {
	width: 500px;
}

.float-r {
	float: right;
}

.float-l {
	float: left;
}

.txtColor-r {
	color: #F00;
}

.txtColor-b {
	color: #00F;
}

.txtColor-w {
	color: #FFF;
}

div.clear-border {
	clear: both;
}
/* ------------------------------------------------------------
    1. Container
   ------------------------------------------------------------ */
div#container {
	width: 100%;
	padding: 0px;
	margin-top: 0px;
	margin-right: auto;
	margin-bottom: 0px;
	margin-left: auto;
}

/* ------------------------------------------------------------
    2. Header
   ------------------------------------------------------------ */
div#header {
	padding-bottom: 0px;
	background-color: #222255;
	color: #000000;
	height: 100px;
	width: 100%;
	float: left;
	display: block;
	position: fixed;
	z-index: 2500;
}

.header-title {
	padding-bottom: 0px;
	background-color: #2E9AFE;
	color: #000000;
	height: 68px;
	width: 100%;
	float: left;
	display: block;
	background-image: url("../image/header-title.jpg");
	background-repeat: repeat;
}

/* ------------------------------------------------------------
    3. Content Layout
   ------------------------------------------------------------ */
div#content {
	width: 1550px;
	float: left;
	margin-left: 10px;
	margin-top: 100px;
	min-height: 500px;
}

/* ------------------------------------------------------------
    4. Customer Dashboard
   ------------------------------------------------------------
*/
div#customer-dashbord {
	background-color: #EEEEEE;
	text-align: left;
	font-size: 13px;
	margin-left: 20px;
}

.order-type {
	width: 600px;
	height: 30px;
	margin-left: 20px;
	margin-bottom: 5px;
	margin-top: 10px;
	/* border : 1px solid #FF9900 */
}

.order-type select {
	size: 1;
}

.customer-info {
	width: 80%;
	margin-left: 0px;
	/* border: 1px solid #FF9900; */
}

.customer-info table {
	width: 100%;
	font-size: 12px;
	vertical-align: baseline;
	border-collapse: separate;
	background-color: #ffffff;
	text-align: left;
}

.customer-info caption {
	caption-side: top;
	background-color: #a6e4ff;
	text-align: left;
}

.customer-info th {
	background-color: #dedfff;
	text-align: left;
}

.customer-info tr {
	background-color: #efebef;
}

.sales-activity {
	width: 80%;
	margin-left: 0px;
	margin-top: 10px;
	/* border: 1px solid #FF9900; */
}

.sales-activity table, .sales-activity th, .sales-activity tr,
	.sales-activity td, .sales-activity caption {
	border: 1px #000000 solid;
}

.sales-activity table {
	width: 100%;
	font-size: 12px;
	vertical-align: baseline;
	border-collapse: collapse;
	background-color: #efebef;
}

.sales-activity th {
	background-color: #6677aa;
	text-align: center;
	color: #FFFFFF;
}

.sales-activity caption {
	caption-side: top;
	background-color: #efebef;
	text-align: left;
	/*height: 30px;*/
}

.sales-activity caption div {
	float: right;
}

.asset {
	width: 80%;
	margin-left: 0px;
	margin-top: 10px;
	/* border: 1px solid #FF9900; */
}

.asset table, .asset th, .asset tr, .asset td, .asset caption {
	border: 1px #000000 solid;
}

.asset table {
	width: 100%;
	font-size: 12px;
	vertical-align: baseline;
	border-collapse: collapse;
	background-color: #efebef;
}

.asset th {
	background-color: #6677aa;
	text-align: center;
	color: #FFFFFF;
}

.asset caption {
	caption-side: top;
	background-color: #efebef;
	text-align: left;
	/*height: 15px;*/
}

.asset caption  div {
	float: right;
}

.sales-history {
	width: 100%;
	margin-left: 0px;
	margin-top: 10px;
	/* border: 1px solid #FF9900; */
}

.sales-history table, .sales-history th, .sales-history tr,
	.sales-history td, .sales-history caption {
	border: 1px #000000 solid;
}

.sales-history table {
	width: 80%;
	font-size: 12px;
	vertical-align: baseline;
	border-collapse: collapse;
	background-color: #efebef;
}

.sales-history th {
	background-color: #6677aa;
	text-align: center;
	color: #FFFFFF;
}

.sales-history caption {
	caption-side: top;
	background-color: #efebef;
	text-align: left;
	height: 15px;
}

/* ------------------------------------------------------------
    5. Side Content
   ------------------------------------------------------------ */
div#sidemenu {
	float: left;
	width: 170px;
	background-color: #9fabc5;
	margin-top: 0px;
	padding-bottom: 50%;
}

.side-title {
	/* background-color: #171717; */
	color: #FFF;
	font-size: 15px;
	text-align: left;
	font-weight: bold;
	padding: 5px 0 5px 0;
	text-indent: 10px;
	height: 20px;
}

/* .side-body ul {
    width: 150;
}

.side-body li {
    margin: 10px 10px 0 10px;
    font-weight: bold;
    border-bottom-width: 1px;
    border-bottom-style: dotted;
    border-bottom-width: 1px;
}

.side-body a:link,a:visited {
    text-decoration: none;
}

.side-body a:hover,a:active {
    text-decoration: underline;
}
*/
.side-body {
	text-align: left;
	width: 100%;
	margin-right: 8px;
	margin-left: 0px;
	margin-bottom: 5px;
	margin-top: 100px;
}

div#tree {
	/* color:#9fabc5; */
	width: 100%;
	height: 300px;
}

img.side-img {
	width: 162px;
	height: 95px;
}

/* ------------------------------------------------------------
    6. Footer
   ------------------------------------------------------------ */
div#footer {
	clear: both;
	background-color: #171717;
	color: #FFFFFF;
	height: 20px;
	width: 100%;
	display: block;
	font-size: 9pt;
	z-index: 5000;
}

div#footer table {
	width: 100%;
	color: #FFFFFF;
	font-size: 9px;
	vertical-align: middle;
}

div#footer td {
	margin: 0;
	text-align: right;
}

div#footer a:link, a:visited, a:hover, a:active {
	text-decoration: underline;
}

div#mainmenu {
	float: left;
	height: 100px;
	width: 100px;
}

.pagingList li {
	display: inline;
	font-weight: bold;
	margin: 5px 0 5px 5px;
}

.frm {
	width: 80%;
	margin-left: 0px;
	margin-bottom: 0.8em;
}

.frm  table {
	width: 100%;
	font-size: 12px;
	vertical-align: baseline;
	border-collapse: separate;
	background-color: #ffffff;
	text-align: left;
}

.frm  table tr {
	height: 25px;
}

.frm  caption {
	caption-side: top;
	background-color: #a6e4ff;
	text-align: left;
	font-weight: bold;
}

.frm  th {
	background-color: #dedfff;
	text-align: left;
}

.frm  tr {
	background-color: #efebef;
}

.frm tr.btn {
	height: 25px;
}

.frm input.currency {
	text-align: right;
}

.tbl {
	width: 80%;
	margin-left: 0px;
	margin-top: 40px;
	/* border: 1px solid #FF9900; */
}

.tbl table, .tbl th, .tbl tr, .tbl td, .tbl caption {
	border: 1px #000000 solid;
}

.tbl table {
	width: 100%;
	font-size: 12px;
	vertical-align: baseline;
	border-collapse: collapse;
	background-color: #efebef;
}

.tbl th {
	background-color: #6677aa;
	text-align: center;
	color: #FFFFFF;
}

.tbl caption {
	caption-side: top;
	background-color: #efebef;
	text-align: left;
	font-weight: bold;
	/*height: 30px;*/
}

.tbl caption div {
	float: right;
}

.tbl table tbody tr td .link {
	text-align: center;
}

div.tblfooter {
	width: 80%;
}

div.tblfooter div {
	float: right;
	margin-top: 5px;
	margin-bottom: 5px;
}

.tbl-command {
	width: 80%;
	text-align: right;
}

.tbl-command tbody tr td {
	width: 80%;
}

.tbl table tbody tr td {
	/* text-align: center;*/
	white-space: nowrap;
}

.tbl input[type="text"] {
	width: 99%;
}

/* ------------------------------------------------------------
    7. Sale Order Entry
   ------------------------------------------------------------ */
div#saleOrderEntry {
	margin-left: 20px;
}

.saleOrderEntryTdLeft {
	font-weight: bold;
	text-align: left;
	font-size: 12px;
}

.saleOrderEntryTdRight {
	font-weight: bold;
	text-align: right;
	font-size: 12px;
	background-color: yellow;
}

.saleOrderEntryTdCenter {
	text-align: center;
	font-weight: bold;
	font-size: 18px;
}

.saleOrderEntryAlignButton {
	margin-left: 360px;
}

/* ------------------------------------------------------------
    8. Button CSS
   ------------------------------------------------------------ */
.button-normal {
	width: 125px;
	height: 25px;
}

.button-large {
	width: 150px;
	height: 25px;
}

div#purchaseInquiry {
	width: 100%;
}

div.header {
	clear: both;
	background-image: url("../image/header_back.png");
	background-repeat: repeat-x;
	color: #ffffff;
	height: 78px;
	font-size: 9pt;
}

div.logo {
	float: left;
	height: 75px;
	margin-left: 20px;
	padding: 0;
	position: absolute;
	width: 100px;
}

div.logo img {
	width: 100px;
}

div.message_panel {
	background-color: #222255;
	height: 46px;
	overflow: auto;
	font-size: 10pt;
	float: left;
	margin-left: 110px;
}

div.message_panel div {
	color: white;
}

div.message_panel div div {
	float: left;
	margin-left: 110px;
}

/* ------------------------------------------------------------
    9. DropdownList CSS
   ------------------------------------------------------------ */
.dropdownlist {
	width: 152px;
	height: 22px;
}

.btnpopup {
	height: 25px;
}

.txttbl {
	width: 120px;
}

.wdtbltd {
	width: 150px;
}

.footer {
	text-align: center;
}

.frm input[type="text"] {
	/*  background: rgba(255, 255, 255, 0.44); 
     color: #333;  */
	border: 1px solid #A4A4A4;
	padding: 4px 8px 4px 4px !important;
	line-height: 1;
	width: 190px;
	height: 15px;
}

.frm input[type="password"] {
	/*  background: rgba(255, 255, 255, 0.44); 
     color: #333;  */
	border: 1px solid #A4A4A4;
	padding: 4px 8px 4px 4px !important;
	line-height: 1;
	width: 190px;
	height: 15px;
}

.frm select {
	border: 1px solid #A4A4A4;
	line-height: 1;
	width: 205px;
	height: 25px;
}

.frm textarea {
	width: 205px;
}

input[readonly="readonly"] {
	background-color: #FAF7CE;
}

input.search {
	background: #FFF url(../image/input-text-9.png) no-repeat 4px 4px;
	border: 1px solid #A4A4A4;
	padding: 4px 8px 4px 4px !important;
	line-height: 1;
	width: 240px;
	height: 15px;
}

/* ------------------------------------------------------------
    12. Column Group
   ------------------------------------------------------------ */
.col-20-left {
	width: 20%;
	text-align: left;
}

.col-30-left {
	width: 30%;
	text-align: left;
}

div#purchaseRequest {
	width: 100%;
}

/* ------------------------------------------------------------
    13. Grid input, nemuric input alignment
   ------------------------------------------------------------ */
.numeric {
	text-align: right;
}

.gridinput {
	width: 97%;
	line-height: 1;
	height: 20px;
}

.col-numeric {
	width: 100px;
}

.tblfooterlabel {
	text-align: right;
	padding-right: 5px;
}

.costSheetEntryLeft {
	font-weight: bold;
	text-align: left;
	font-size: 12px;
}

.costSheetEntryRightY {
	text-align: right;
	font-size: 12px;
	background-color: #FAF7CE;
}

.costSheetEntryRightB {
	text-align: right;
	font-size: 12px;
	background-color: #cee7fa;
}

.costSheetEntryCenter {
	text-align: center;
	font-weight: bold;
	font-size: 13px;
}

.costSheetEntrySpecHead {
	font-weight: bold;
	background-color: #cee7fa;
}

/*----- Tabs -----*/
.tabs {
	width: 100%;
	display: inline-block;
}

/*----- Tab Links -----*/
/* Clearfix */
.tab-links:after {
	display: block;
	clear: both;
	content: '';
}

.tab-links li {
	margin: 0px 5px;
	float: left;
	list-style: none;
}

.tab-links a {
	padding: 9px 15px;
	display: inline-block;
	border-radius: 3px 3px 0px 0px;
	background: #7FB5DA;
	font-size: 16px;
	font-weight: 600;
	color: #4c4c4c;
	transition: all linear 0.15s;
}

.tab-links a:hover {
	background: #a7cce5;
	text-decoration: none;
}

li.active a, li.active a:hover {
	background: #fff;
	color: #4c4c4c;
}

/*----- Content of Tabs -----*/
.tab-content {
	padding: 15px;
	border-radius: 3px;
	box-shadow: -1px 1px 1px rgba(0, 0, 0, 0.15);
	background: #fff;
}

.tab {
	display: none;
}

.tab.active {
	display: block;
}

/* ------------------------------------------------------------
    15. Part Order List Inquiry
   ------------------------------------------------------------ */
.button-purchasereq {
	width: 200px;
	height: 20px;
}

.div-bottombutton {
	width: 81.5%;
	margin-left: 0px;
	text-align: right;
}

div#partorderlist {
	margin-left: 20px;
}

.tr-button {
	height: 25px;
}

.td-button {
	text-align: right;
}

.td-checkbox {
	text-align: center;
}

.tblcenter {
	text-align: center;
}

#btnLogin {
	width: 160px;
	height: 30px;
}

.approval-entry {
	padding: 10px;
	/*border: medium none; margin: 0px; padding: 0px; width: 100%; height: 100%; top: 0px; left: 0px; background-color: rgb(0, 0, 0); opacity: 0.6; cursor: wait; 
    */
}

.td-center {
	text-align: center;
}

/* ------------------------------------------------------------
    21. Search Customer
   ------------------------------------------------------------ */
.search-customer {
	background-color: #EEEEEE;
	text-align: left;
	font-size: 13px;
	margin-left: 20px;
}

.search-customer fieldset {
	margin-top: 20px;
	width: 80%;
}

.button-receivingsch {
	width: 150px;
	height: 20px;
}

.templateLink {
	margin-left: 80px;
}

/*------Haead Lgoin Page----------*/
/*
html.sb-init body div#wrapper div#sb-site div#container div#header div.header div:nth-child(2){
    height: 35px;
    color: white;
}
html.sb-init body div#wrapper div#sb-site div#container div#header div.header div:nth-child(2) div:nth-child(1) {
    margin-left: 110px;
    margin-top: 10px;
    display: inline;
    float: left;
    font-size: larger;
    
}
html.sb-init body div#wrapper div#sb-site div#container div#header div.header div:nth-child(2) div:nth-child(1) span:nth-child(1) {
    font-size: larger;
}
html.sb-init body div#wrapper div#sb-site div#container div#header div.header div:nth-child(2) div:nth-child(1) span:nth-child(2) {
    float: left;
    font-size: larger;
}
html.sb-init body div#wrapper div#sb-site div#container div#header div.header div:nth-child(2) div:nth-child(2) {
    margin-left: 20px;
    float: right;
    font-size: smaller;
    
}
html.sb-init body div#wrapper div#sb-site div#container div#header div.header div:nth-child(2) div:nth-child(3) {
   margin-left: 20px;
   float: right;
}
* /

html body div#container div#header div.header div div:nth-child(1){
    div#header div.header div:nth-child(1){
    display: inline;
    float: left;
    font-size: larger;
    margin-left: 110px;
    margin-top: 10px;
}

html body div#container div#header div.header div div:nth-child(2){
    display: inline;
    float: left;
    font-size: larger;
    margin-left: 110px;
    margin-top: 10px;
}

html body div#container div#header div.header div div:nth-child(3){
    float: right;
    margin-left: 20px;
}

html body div#container div#header div.header div div span:nth-child(1){
    font-size: larger;
}

html body div#container div#header div.header div div span:nth-child(2){
    float: left;
    font-size: larger;
}


*/
/*
    Header
*/
.header-panel {
	background-image: url("../image/header_back.png");
	background-repeat: repeat-x;
	clear: both;
	color: #ffffff;
	font-size: 9pt;
	height: 60px;
	background-color: red;
}

.header-system-name {
	font-size: x-large;
	float: left;
	height: 75px;
	margin-top: 10px;
	margin-left: 130px;
	font-size: x-large;
	padding: 0;
	position: absolute;
	width: 50%;
	font-weight: bold;
}

.header-system-name span.system {
	font-size: medium;
	font-weight: normal;
}

.header-user-profile {
	float: right;
	/* height: 75px;*/
	font-size: smaller;
	padding: 0;
	margin-top: 10px;
	margin-right: 50px;
	width: 300px;
}

.header-user-profile span {
	float: right;
}

.header-user-profile table {
	float: right;
	font-size: larger;
}

.message-panel {
	margin: 0px;
	height: 52px;
	clear: both;
}

.message-panel span {
	margin-left: 110px;
	margin-top: 0px;
	font-size: 10pt;
	color: white;
}

.message-panel div {
	margin-left: 200px;
	margin-top: -18px;
	font-size: 10pt;
	color: white;
	clear: both;
	width: 500px;
	white-space: pre-wrap;
}

.header-menu {
	float: left;
	height: 35px;
	margin-left: 0px;
	margin-top: 30px;
	padding: 0;
	position: absolute;
	width: 20px;
	text-align: center;
}

th.currency {
	width: 150px;
}

td.currency {
	text-align: right;
}

th.qty {
	
}

.tbl input.textpopup {
	width: 80%;
}

.tbl input.currency {
	text-align: right;
}

div.contentpanel {
	background-color: #EEEEEE;
	text-align: left;
	font-size: 13px;
	margin-left: 20px;
	margin-top: 20px;
}
.loading-screen {
	background: none repeat scroll 0 0 rgba(0, 0, 0, 0.85);
	position: fixed;
	top: 0;
	left: 0;
	bottom: 0;
	right: 0;
	opacity: 0.7;
	cursor: wait;
}

.loading-indicator {
	clear: both;
	position: absolute;
	display: block;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

.loading-images {
	clear: both;
	position: relative;
	display: block;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

.main {
	width: 400px;
	height: 400Px;
	-webkit-flex-flow: row wrap; /* Safari 6.1+ */
	-webkit-align-content: space-around; /* Safari 7.0+ */
	display: flex;
	flex-flow: row wrap;
	align-content: space-around;
	display: -webkit-flex;
}
</style>
<script type="text/javascript" language="javascript"
	src="resources/js/jquery.js"></script>
</head>
<body>
	<div class="search-customer">
		<fieldset>
			<legend>
				<b>Select&nbsp;Customer</b>
			</legend>
			<table class="frm">
				<tbody>
					<tr>
						<th>Code</th>
						<td><input type="text" /></td>
						<th>Name</th>
						<td><input type="text" /></td>
					</tr>
				</tbody>
			</table>
		</fieldset>
		<table class="tbl-command">
			<tr>
				<td>&nbsp;</td>
				<td width="50%">&nbsp;</td>
				<td width="50%" align="right"><input id="search" name="search"
					type="button" value="Search" class="width7"></td>
			</tr>
		</table>
		<div class="tbl">
			<table>
				<tbody>
					<tr>
						<th>Code</th>
						<th>Name</th>
						<th>Site</th>
						<th>Contact&nbsp;Person</th>

					</tr>
					<tr>
						<td align="center"><a href="#">34000228</a></td>
						<td>ABSOLUTE&nbsp;DENIM CO.,&nbsp;LTD.</td>
						<td>HQ</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td align="center"><a href="#">34010032</a></td>
						<td>KHOLER&nbsp;(THAILAND)&nbsp;PUBLIC&nbsp;COMPANY&nbsp;LIMITED</td>
						<td>HQ</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td align="center"><a href="#">34009045</a></td>
						<td>SIAM&nbsp;KUBOTA&nbsp;CORPORATION&nbsp;CO.,&nbsp;LTD.</td>
						<td>HQ</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td align="center"><a href="#">34000135</a></td>
						<td>SUMITOMO&nbsp;RUBBER&nbsp;(THAILAND)&nbsp;CO.,&nbsp;LTD.</td>
						<td>HQ</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td align="center"><a href="#">34001313</a></td>
						<td>SV1ZZ-ONE&nbsp;CORPORATION&nbsp;LTD.</td>
						<td>HQ</td>
						<td>&nbsp;</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<script>
    $(function(){
    	$('#search').click(function(event){
    		$('.loading-screen').show();	
    		//event.preventDefault();
    		
    		
    		/*
    		setTimeout(function(){
    			if (window.opener != null && !window.opener.closed) {
        			window.opener.document.getElementById("data1").value = "data00012354112";
        		}
        		window.opener.$('.loading-screen').hide();
        		window.close();
    		},5000);
    		
    		*/
    	});	
    });
    
	
    
 
	</script>
	<!-- Start Loading Screen -->
	<div class="loading-screen">
		<div class="loading-indicator">
			<div class="main">
				<div class="loading-images">
					<img src="resources/images/TTFL_LOGO_Blue.png"></img>
				</div>
				<div class="loading-images">
					<img src="resources/images/loading3.gif"></img>
				</div>
			</div>
		</div>
	</div>
	<script>
		$(function() {
			$('.loading-screen').hide();
			/*
			$(':submit').click(function(event) {
				//var thisVar = this;
				event.preventDefault();
				$('.loading-screen').show();
				setTimeout(function() {
					$('form').submit();
				}, 100);
			});*/
		});
	</script>
	<!-- End Loading Screen -->
</body>
</html>