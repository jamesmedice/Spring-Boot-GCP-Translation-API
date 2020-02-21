package com.medici.app.utils;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;

/**
 * 
 * @author a73s
 *
 */
public class TranslatorUtils {

	public static Translate createTranslateService() {
		return TranslateOptions.newBuilder().build().getService();
	}

}
