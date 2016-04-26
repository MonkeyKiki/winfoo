package com.orange.upro.winfoo.web.pgm;

import java.io.IOException;
import java.util.Scanner;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

	@Autowired
	PgmFileValidator fileValidator;

	@Autowired
	PgmManager pgmManager;

	@InitBinder("pgmFile")
	protected void initBinderFileBucket(WebDataBinder binder) {
		binder.setValidator(fileValidator);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(ModelMap model) {
		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		return "welcome";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String getUploadPage(ModelMap model) {
		PgmFile fileModel = new PgmFile();
		model.addAttribute("pgmFile", fileModel);
		return "fileUploader";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String fileUpload(@Valid PgmFile pgmFile, BindingResult result, ModelMap model) throws IOException {

		if (result.hasErrors()) {
			System.out.println("validation errors");
			return "fileUploader";
		} else {
			MultipartFile multipartFile = pgmFile.getFile();

			Scanner scanner = new Scanner(multipartFile.getInputStream(), "ISO-8859-1");
			scanner.useDelimiter("\r\n");
			// On ignore les headers
			String line = scanner.next();
			int numLigne = 1;
			while (scanner.hasNext()) {
				line = scanner.next();
				numLigne++;
				// On ignore le lignes vides
				if (!line.matches(";+")) {
					String cells[] = line.split(";", -1);
					// System.out.println(cells.length);
					// System.out.println(line);

					try {
						Pgm pgmCourant = new Pgm();
						pgmCourant.setAnneeDemande(Integer.parseInt(cells[1]));
						// pgmCourant.setDateEchangeDoDmgp(cells[2]);
						pgmCourant.setDo_(cells[3]);
						pgmCourant.setDr(cells[4]);
						pgmCourant.setDpt(Integer.parseInt(cells[5]));
						pgmCourant.setVillesFtth(cells[6]);
						pgmCourant.setDeployeur(cells[7]);
						pgmCourant.setZone(cells[8]);
						pgmCourant.setLotsDeployes(cells[9]);
						// pgmCourant.setPrevisionDatePublication(cells[10]);
						// pgmCourant.setRepublication(cells[11]);
						pgmCourant.setNraImpactes(cells[12]);
						pgmCourant.setNroImpactes(cells[13]);
						pgmCourant.setMiseEnService1Olt(cells[14]);
						pgmCourant.setZmLot(Integer.parseInt(cells[15]));
						pgmCourant.setLotPublie(Integer.parseInt(cells[16]));
						pgmCourant.setPrevRaccordableDooDonc(Integer.parseInt(cells[17]));
						pgmCourant.setPriorite(cells[18]);
						pgmCourant.setOlt(cells[19]);
						pgmCourant.setEtude(Integer.parseInt(cells[20]));
						pgmCourant.setExtensionOlt(Integer.parseInt(cells[21]));
						pgmCourant.setLogement(cells[22]);

						pgmManager.insertPgm(pgmCourant);
					} catch (Exception e) {
						System.err.println("Erreur lors de la lecture de ligne " + numLigne + " : " + e.getMessage());
						// e.printStackTrace();
					}
				}
			}
			scanner.close();

			String fileName = multipartFile.getOriginalFilename();
			model.addAttribute("fileName", fileName);
			return "success";
		}
	}

}