package com.orange.upro.winfoo.web.pgm;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.orange.upro.winfoo.manager.PgmManager;
import com.orange.upro.winfoo.model.Pgm;

@Controller
@RequestMapping("/")
public class PgmFileController {
	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

	@Autowired
	PgmFileValidator fileValidator;

	@Autowired
	PgmManager pgmManager;

	@InitBinder("pgmFileForm")
	protected void initBinderFileBucket(WebDataBinder binder) {
		binder.setValidator(fileValidator);
	}

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String getUploadPage(ModelMap model) {
		PgmFileForm fileModel = new PgmFileForm();
		model.addAttribute("pgmFileForm", fileModel);
		return "fileUploader";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String fileUpload(@Valid PgmFileForm pgmFileForm, BindingResult result, ModelMap model) throws IOException {

		if (result.hasErrors()) {
			return "fileUploader";
		} else {
			if (pgmFileForm.isPurgeData()) {
				pgmManager.deleteAllPgms();
			}
			
			MultipartFile multipartFile = pgmFileForm.getFile();

			Scanner scanner = new Scanner(multipartFile.getInputStream(), "ISO-8859-1");
			scanner.useDelimiter("\r\n");
			String line;
			StringBuilder errors = new StringBuilder();
			if (pgmFileForm.isPresenceEntetes()) {
				// On ignore les headers
				scanner.next();
			}
			int numLigne = 1;
			while (scanner.hasNext()) {
				line = scanner.next();
				numLigne++;
				// On ignore le lignes vides
				if (!line.matches(";+")) {
					String cells[] = line.split(";", -1);

					try {
						Pgm pgmCourant = new Pgm();
						if (StringUtils.hasText(cells[1])) {
							pgmCourant.setAnneeDemande(Integer.parseInt(cells[1]));
						}
						if (StringUtils.hasText(cells[2])) {
							pgmCourant.setDateEchangeDoDmgp(DATE_FORMAT.parse(cells[2]));
						}
						pgmCourant.setDo_(cells[3]);
						pgmCourant.setDr(cells[4]);
						if (StringUtils.hasText(cells[5])) {
							pgmCourant.setDpt(Integer.parseInt(cells[5]));
						}
						pgmCourant.setVillesFtth(cells[6]);
						pgmCourant.setDeployeur(cells[7]);
						pgmCourant.setZone(cells[8]);
						pgmCourant.setLotsDeployes(cells[9]);
						if (StringUtils.hasText(cells[10])) {
							pgmCourant.setPrevisionDatePublication(DATE_FORMAT.parse(cells[10]));
						}
						if (StringUtils.hasText(cells[11])) {
							pgmCourant.setRepublication(DATE_FORMAT.parse(cells[11]));
						}
						pgmCourant.setNraImpactes(cells[12]);
						pgmCourant.setNroImpactes(cells[13]);
						pgmCourant.setMiseEnService1Olt(cells[14]);
						if (StringUtils.hasText(cells[15])) {
							pgmCourant.setZmLot(Integer.parseInt(cells[15]));
						}
						if (StringUtils.hasText(cells[16])) {
							pgmCourant.setLotPublie(Integer.parseInt(cells[16]));
						}
						pgmCourant.setPrevRaccordableDooDonc(cells[17]);
						pgmCourant.setPriorite(cells[18]);
						pgmCourant.setOlt(cells[19]);
						if (StringUtils.hasText(cells[20])) {
							pgmCourant.setEtude(Integer.parseInt(cells[20]));
						}
						if (StringUtils.hasText(cells[21])) {
							pgmCourant.setExtensionOlt(Integer.parseInt(cells[21]));
						}
						pgmCourant.setLogement(cells[22]);

						pgmManager.insertPgm(pgmCourant);
					} catch (Exception e) {
						errors.append(numLigne + " : " + e.getClass() + "-" + e.getMessage() + "<BR/>");
						e.printStackTrace();
					}
				}
			}
			scanner.close();

			String fileName = multipartFile.getOriginalFilename();
			model.addAttribute("fileName", fileName);
			model.addAttribute("errors", errors.toString());
			return "success";
		}
	}

}