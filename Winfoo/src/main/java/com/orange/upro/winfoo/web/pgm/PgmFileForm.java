package com.orange.upro.winfoo.web.pgm;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author beaufils
 */
public class PgmFileForm {

    private MultipartFile file;
    private boolean presenceEntetes = true;
    private boolean purgeData = false;

    public boolean isPresenceEntetes() {
		return presenceEntetes;
	}

	public void setPresenceEntetes(boolean presenceEntetes) {
		this.presenceEntetes = presenceEntetes;
	}

	public boolean isPurgeData() {
		return purgeData;
	}

	public void setPurgeData(boolean purgeData) {
		this.purgeData = purgeData;
	}

	public MultipartFile getFile() {    
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
