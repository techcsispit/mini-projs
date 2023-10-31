const searchButton = document.getElementById('search-button');
const searchInput = document.getElementById('search-input');
const moviePoster = document.getElementById('poster');
const movieInfoText = document.getElementById("movieInfoText");
const apiKey = '5b32bde5'; 

async function displaySearch(query) {
    const search = `https://www.omdbapi.com/?t=${query}&apikey=${apiKey}`;
    
    try {
        const response = await fetch(search);
        const data = await response.json();
        if(data.Response === "True"){
            movieInfoText.innerHTML = `
            <h2>${data.Title}</h2>
            <p>Year: ${data.Year}</p>
            <p>Genre: ${data.Genre}</p>
            <p>Director: ${data.Director}</p>
            <p>Actors: ${data.Actors}</p>
            <p>Plot: ${data.Plot}</p>
            <p>Awards: ${data.Awards}</p>
            <p>Runtime: ${data.Runtime}</p>
            <p>Language: ${data.Language}</p>
            <p>Country: ${data.Country}</p>
            <p>Production: ${data.Production}</p>
            <p>Box Office: ${data.BoxOffice}</p>
            <p>DVD Release Date: ${data.DVD}</p>
            <p>Website: ${data.Website}</p>
            <p>Metascore: ${data.Metascore}</p>
            <p>IMDb Rating: ${data.imdbRating}</p>`
            moviePoster.innerHTML = `<img src="${data.Poster}" alt="${data.Title} Poster"</img>`;
        } else{
            movieInfoText.innerHTML = "No results found";
        }
    } catch(error){
        console.error('Error fetching data: ', error);
    }
}

searchButton.addEventListener('click', () => {
    const query = searchInput.value;
    if(query){
        displaySearch(query);
    }
})
searchInput.addEventListener('keydown', (event) => {
    if (event.keyCode === 13) {
        const query = searchInput.value;
        if(query){
            displaySearch(query);
        }
    }
});
