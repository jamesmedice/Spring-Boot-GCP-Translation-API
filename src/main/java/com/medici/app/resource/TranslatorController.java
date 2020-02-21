package com.medici.app.resource;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.translate.Language;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.medici.app.entity.TranslationMessage;

/**
 * 
 * @author a73s
 *
 */
@RestController
public class TranslatorController {

	private static final String TARGET_LANGUAGE_ES = "es";

	protected Logger logger = Logger.getLogger(TranslatorController.class.getName());

	@RequestMapping(value = "/translate", method = RequestMethod.POST)
	public String translate(@RequestBody TranslationMessage message) {
		try {
			Translate translate = TranslateOptions.getDefaultInstance().getService();
			Translation translation = translate.translate(message.getText(), TranslateOption.sourceLanguage(message.getSourceLanguage()), TranslateOption.targetLanguage(message.getTargetLanguage()));
			return translation.getTranslatedText();
		} catch (Exception e) {
			return null;
		}
	}

	@RequestMapping(value = "/languages", method = RequestMethod.GET)
	public List<Language> languages() {
		try {
			Translate translate = TranslateOptions.getDefaultInstance().getService();
			List<Language> languages = translate.listSupportedLanguages(Translate.LanguageListOption.targetLanguage(TARGET_LANGUAGE_ES));
			return languages;
		} catch (Exception e) {
			return null;
		}
	}

}
