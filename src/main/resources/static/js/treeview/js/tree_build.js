/*set the number of total pages
 * 
 * */

function buildDomTree() {
		var data = [ {
			text : "Access Code France1",
			nodes : [
					{
						text : "1111",
						icon : 'glyphicon glyphicon-file'
					},
					{
						text : "2222",
						icon : 'glyphicon glyphicon-file',
						tags : [ '<i class="glyphicon glyphicon-exclamation-sign"></i>' ]
					},
					{
						text : "3333",
						icon : 'glyphicon glyphicon-file'
					},
					{
						text : "BANQUES POPULAIRES",
						nodes : [
								{
									text : "4444",
									icon : 'glyphicon glyphicon-file',
									tags : [ '<i class="glyphicon glyphicon-info-sign"></i>' ]
								}, {
									text : "5555",
									icon : 'glyphicon glyphicon-file'
								}, {
									text : "6666",
									icon : 'glyphicon glyphicon-file'
								} ]
					},
					{
						text : "BANQUES POPULAIRES",
						nodes : [
								{
									text : "7777",
									icon : 'glyphicon glyphicon-file',
									tags : [ '<i class="glyphicon glyphicon-remove-circle"></i>' ]
								}, {
									text : "8888",
									icon : 'glyphicon glyphicon-file'
								}, {
									text : "9999",
									icon : 'glyphicon glyphicon-file'
								}, {
									text : "321321",
									icon : 'glyphicon glyphicon-file'
								} ]
					} ]
		} ];

		return data;
	}

	$(function() {

		var options = {
			bootstrap2 : false, //bootstrap2 can't work,only 3 or above
			showTags : true,
			levels : 5,
			nodeIcon : '',
			expandIcon : 'glyphicon glyphicon-chevron-down',
			collapseIcon : 'glyphicon glyphicon-chevron-up',
			data : buildDomTree()
		};

		$('#treeview').treeview(options);
	});