 
 favoriteIcons.forEach(icon => {
   icon.addEventListener('click', () => {
     icon.classList.toggle('favorited');
   });
 });

 function toggleFavorite() {
  var button = document.querySelector('.favorite-button');
  button.classList.toggle('favorite');
  
  var buttonText = button.querySelector('.favorite-text');
  buttonText.textContent = button.classList.contains('favorite') ? 'Favoritado' : 'Favoritar';
}
