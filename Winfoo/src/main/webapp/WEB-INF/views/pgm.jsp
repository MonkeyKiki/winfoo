<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>PGM</title>

<spring:url value="/resources/jquery/jquery-2.2.1.min.js" var="jqueryJs" />
<spring:url value="/resources/jquery-ui/jquery-ui.min.css" var="jqueryUiCss" />
<spring:url value="/resources/jquery-ui/jquery-ui.min.js" var="jqueryUiJs" />
<spring:url value="/resources/jtable/themes/lightcolor/green/jtable.min.css" var="jtableCss" />
<spring:url value="/resources/jtable/jquery.jtable.min.js" var="jtableJs" />
<spring:url value="/resources/jtable/localization/jquery.jtable.fr.js" var="jtableFrJs" />

<script src="${jqueryJs}" type="text/javascript"></script>
<link rel="stylesheet" href="${jqueryUiCss}">
<script src="${jqueryUiJs}"></script>
<link href="${jtableCss}" rel="stylesheet"
	type="text/css" />
<script src="${jtableJs}" type="text/javascript"></script>
<script src="${jtableFrJs}" type="text/javascript"></script>

<style type="text/css">

div.jtable-main-container table.jtable thead th.jtable-column-header div.jtable-column-header-container {
	height:auto;
}

</style>

</head>

<body>
	<div id="PgmTableContainer"></div>

	<script type="text/javascript">
    $(document).ready(function () {
        $('#PgmTableContainer').jtable({
            title: 'PGM',
            actions: {
                listAction: 'rest/pgm/list',
                createAction: 'rest/pgm/create',
                updateAction: 'rest/pgm/update',
                deleteAction: 'rest/pgm/delete'
            },
            fields: {
                id: {
                    title: 'N° Demande',
                    key: true
                },
                anneeDemande: {
                    title: 'Année demande DO/DMGP'
                },
                dateEchangeDoDmgp: {
                	title: 'DATE ECHANGE DO/DMGP',
                	type: 'date',
                	displayFormat: 'dd/mm/yy'
                },
               	do_: {
                	title: 'DO'
                },
               	dr: {
                	title: 'DR'
                },
               	dpt: {
                	title: 'DPT'
                },
               	villesFtth: {
                	title: 'Villes FTTH'
                },
               	deployeur: {
                	title: 'Déployeur'
                },
               	zone: {
                	title: 'Zone'
                },
               	lotsDeployes: {
                	title: 'Lots déployés'
                },
               	previsionDatePublication: {
                	title: 'Prévision Date publication du lot<br/>Vert fluo = publié',
                    type: 'date',
                	displayFormat: 'dd/mm/yy'
                },
               	republication: {
                	title: 'REPUBLICATION',
                    type: 'date',
                	displayFormat: 'dd/mm/yy'
                },
               	nraImpactes: {
                	title: 'NRA IMPACTES<br/>barré : non déployé cause budget'
                },
               	nroImpactes: {
                	title: 'NRO IMPACTES'
                },
               	miseEnService1Olt: {
                	title: 'Mise en service du 1er OLT'
                },
               	zmLot: {
                	title: 'ZM Lot',
                	display: function (data) {
                		if (data.record.zmLot == '0') {
                			return "<label style='color:red;'>" + data.record.zmLot + "</label>";
                		} else {
                			return "<label style='color:green;'>" + data.record.zmLot + "</label>";
                		}
                    }
                },
               	lotPublie: {
                	title: 'Lot publié',
                	display: function (data) {
                		if (data.record.lotPublie == '0') {
                			return "<label style='color:red;'>" + data.record.lotPublie + "</label>";
                		} else {
                			return "<label style='color:green;'>" + data.record.lotPublie + "</label>";
                		}
                    }
                },
               	prevRaccordableDooDonc: {
                	title: 'prev raccordable DOO-DONC'
                },
               	priorite: {
                	title: 'Priorite'
                },
               	olt: {
                	title: 'OLT'
                },
                etude: {
                	title: 'ETUDE NRO',
                	display: function (data) {
                		if (data.record.etude == '0') {
                			return "<label style='color:red;'>" + data.record.etude + "</label>";
                		} else {
                			return "<label style='color:green;'>" + data.record.etude + "</label>";
                		}
                    }
                },
               	extensionOlt: {
                	title: 'Extension OLT',
                	display: function (data) {
                		if (data.record.extensionOlt == '0') {
                			return "<label style='color:red;'>" + data.record.extensionOlt + "</label>";
                		} else {
                			return "<label style='color:green;'>" + data.record.extensionOlt + "</label>";
                		}
                    }
                },
               	logement: {
                	title: 'LOGEMENT'
                }
            }
        });
        
        $('#PgmTableContainer').jtable('load');
    });
</script>

</body>

</html>