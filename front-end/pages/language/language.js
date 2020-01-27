var englishDictionary = {
    'select-language': 'Select language',
    'english': 'English',
    'german': 'German',
    'french': 'French',
    'romanian': 'Romanian',
    'next': 'Next'
}

var germanDictionary = {
    'select-language': 'Wählen Sie die Sprache',
    'english': 'Englisch',
    'german': 'Deutsch',
    'french': 'Französisch',
    'romanian': 'Rumänisch',
    'next': 'Nächste'
}

var frenchDictionary = {
    'select-language': 'Sélectionnez la langue',
    'english': 'Anglais',
    'german': 'Allemand',
    'french': 'Français',
    'romanian': 'Roumain',
    'next': 'Suivant'
}

var romanianDictionary = {
    'select-language': 'Selectează limba',
    'english': 'Engleză',
    'german': 'Germană',
    'french': 'Franceză',
    'romanian': 'Română',
    'next': 'Următorul'
}

function initLanguage() {
    setLanguage(englishDictionary)
}

function setLanguage(dictionary) {
    for(var key in dictionary) {
        document.getElementById(key).innerHTML=dictionary[key];
    }
}

function changeLanguage(id) {
    if(id === 'en') {
        setLanguage(englishDictionary);
    }
    if(id === 'de') {
        setLanguage(germanDictionary);
    }
    if(id === 'fr') {
        setLanguage(frenchDictionary);
    }
    if(id === 'ro') {
        setLanguage(romanianDictionary);
    }
}