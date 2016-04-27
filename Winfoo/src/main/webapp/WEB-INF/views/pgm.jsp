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
                	title: 'DATE ECHANGE DO/DMGP'
                },
               	deployeur: {
                	title: 'Déployeur'
                },
               	do_: {
                	title: 'DO'
                },
               	dpt: {
                	title: 'DPT'
                },
               	dr: {
                	title: 'DR'
                },
               	etude: {
                	title: 'ETUDE NRO'
                },
               	extensionOlt: {
                	title: 'Extension OLT'
                },
               	logement: {
                	title: 'LOGEMENT'
                },
               	lotPublie: {
                	title: 'Lot publié'
                },
               	lotsDeployes: {
                	title: 'Lots déployés'
                },
               	miseEnService1Olt: {
                	title: 'Mise en service du 1er OLT'
                },
               	nraImpactes: {
                	title: 'NRA IMPACTES<br/>barré : non déployé cause budget'
                },
               	nroImpactes: {
                	title: 'NRO IMPACTES'
                },
               	olt: {
                	title: 'OLT'
                },
               	prevRaccordableDooDonc: {
                	title: 'prev raccordable DOO-DONC'
                },
               	previsionDatePublication: {
                	title: 'Prévision Date publication du lot<br/>Vert fluo = publié'
                },
               	priorite: {
                	title: 'Priorite'
                },
               	republication: {
                	title: 'REPUBLICATION'
                },
               	villesFtth: {
                	title: 'Villes FTTH'
                },
               	zmLot: {
                	title: 'ZM Lot'
                },
               	zone: {
                	title: 'Zone'
                }
            }
        });
        
        $('#PgmTableContainer').jtable('load');
    });
</script>

</body>

</html>