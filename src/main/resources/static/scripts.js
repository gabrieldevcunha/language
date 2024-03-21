document.addEventListener('DOMContentLoaded', function() {
    const languageList = document.getElementById('language-list');

    function fetchLanguages() {
        fetch('/language/all')
            .then(response => response.json())
            .then(languages => {
                languageList.innerHTML = '';
                languages.forEach(language => {
                    const listItem = document.createElement('li');
                    listItem.innerHTML = `<span>${language.sigla} - ${language.language}</span>
                                          <button onclick="updateLanguage(${language.languageId})">Atualizar</button>
                                          <button onclick="deleteLanguage(${language.languageId})">Excluir</button>`;
                    languageList.appendChild(listItem);
                });
            })
            .catch(error => console.error('Erro ao buscar linguagens:', error));
    }

    window.deleteLanguage = function(languageId) {
        if (confirm('Tem certeza que deseja excluir esta linguagem?')) {
            fetch(`/language/delete/${languageId}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                }
            })
            .then(response => {
                if (response.ok) {
                    fetchLanguages();
                } else {
                    throw new Error('Erro ao excluir linguagem');
                }
            })
            .catch(error => console.error('Erro ao excluir linguagem:', error));
        }
    }

    window.updateLanguage = function(languageId) {
        fetch(`/language/${languageId}`)
            .then(response => response.json())
            .then(language => {
                document.getElementById('edit-language-id').value = language.languageId;
                document.getElementById('edit-language-sigla').value = language.sigla;
                document.getElementById('edit-language-language').value = language.language;

                document.getElementById('edit-language-form').style.display = 'block';
            })
            .catch(error => console.error('Erro ao buscar linguagem para edição:', error));
    }

    function submitUpdatedLanguage(event) {
        event.preventDefault();

        const formData = new FormData(event.target);
        const languageId = formData.get('languageId');
        const sigla = formData.get('sigla');
        const language = formData.get('language');

        fetch(`/language/update/${languageId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ sigla, language })
        })
        .then(response => {
            if (response.ok) {
                fetchLanguages();
                document.getElementById('edit-language-form').style.display = 'none';
            } else {
                throw new Error('Erro ao atualizar linguagem');
            }
        })
        .catch(error => console.error('Erro ao atualizar linguagem:', error));
    }

    function cancelUpdate() {
        document.getElementById('edit-language-form').style.display = 'none';
    }

    fetchLanguages();
});
