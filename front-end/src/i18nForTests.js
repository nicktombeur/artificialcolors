// TODO necessary? use the "prod" one too?
import i18n from 'i18next';
import {initReactI18next} from 'react-i18next';

i18n
    .use(initReactI18next)
    .init({
            lng: "en-GB",
            fallbackLng: 'en-GB',
            debug: true,
            interpolation: {
                escapeValue: false, // not needed for react!!
            },
            resources: {
                "en-GB": {
                    translation: {
                        "filter": "Filter..."
                    }
                }
            }
        }
    );

export default i18n;