const player1 = {
    id: 1,
    char: 'x',
    iconClass: 'fa-times',
    scoreClass: '#score-player-1 .score-text'
};

const player2 = {
    id: 2,
    char: 'o',
    iconClass: 'fa-circle',
    scoreClass: '#score-player-2 .score-text'
};

let currentPlayer = player1;

function switchPlayer() {
    currentPlayer = currentPlayer.id === 1 ? player2 : player1;
    
    const currentPlayerElement = document.getElementById('current-player');
    currentPlayerElement.innerText = currentPlayer.char.toUpperCase();
}

/**
 * Place the current player's icon within the tile.
 * 
 * @param {Element} tile - the tile to record the move within
 */
function recordMove(tile) {
    // TODO - 1) find the icon inside the tiel (i element)
    const iconToUpdate = tile.querySelector('i');
    // 2) update the class of the icon to display the X or the O based on class
    iconToUpdate.classList.add(currentPlayer.iconClass);
}

/**
 * Returns true if the current player has won. A win can
 * be three in a row horizontally, vertically, or diagonally.
 * 
 * @returns {boolean} true if the current player has won, false otherwise
 */
function isAWin() {
    // Horizontal Wins
    const topLeft = document.querySelector('.top.left > i');
    const topCenter = document.querySelector('.top.center > i');
    const topRight = document.querySelector('.top.right > i');

    const centerLeft = document.querySelector('.center.left > i');
    const centerCenter = document.querySelector('.center.middle > i');
    const centerRight = document.querySelector('.center.right > i');

    const bottomLeft = document.querySelector('.bottom.left > i');
    const bottomCenter = document.querySelector('.bottom.center > i');
    const bottomRight = document.querySelector('.bottom.right > i');

    if(topLeft.classList.contains(currentPlayer.iconClass)
    && topCenter.classList.contains(currentPlayer.iconClass)
    && topRight.classList.contains(currentPlayer.iconClass)) {
        return true;
    }

    if(centerLeft.classList.contains(currentPlayer.iconClass)
    && centerCenter.classList.contains(currentPlayer.iconClass)
    && centerRight.classList.contains(currentPlayer.iconClass)) {
        return true;
    }

    if(bottomLeft.classList.contains(currentPlayer.iconClass)
    && bottomCenter.classList.contains(currentPlayer.iconClass)
    && bottomRight.classList.contains(currentPlayer.iconClass)) {
        return true;
    }


    //Vertical Wins
        if(topLeft.classList.contains(currentPlayer.iconClass)
    && centerLeft.classList.contains(currentPlayer.iconClass)
    && bottomLeft.classList.contains(currentPlayer.iconClass)) {
        return true;
    }

    if(topCenter.classList.contains(currentPlayer.iconClass)
    && centerCenter.classList.contains(currentPlayer.iconClass)
    && bottomCenter.classList.contains(currentPlayer.iconClass)) {
        return true;
    }

    if(topRight.classList.contains(currentPlayer.iconClass)
    && centerRight.classList.contains(currentPlayer.iconClass)
    && bottomRight.classList.contains(currentPlayer.iconClass)) {
        return true;
    }


    //Diagonal Wins

    if(topLeft.classList.contains(currentPlayer.iconClass)
    && centerCenter.classList.contains(currentPlayer.iconClass)
    && bottomRight.classList.contains(currentPlayer.iconClass)) {
        return true;
    }

    if(topRight.classList.contains(currentPlayer.iconClass)
    && centerCenter.classList.contains(currentPlayer.iconClass)
    && bottomLeft.classList.contains(currentPlayer.iconClass)) {
        return true;
    }

    return false;
}

/**
 * Returns true if there is a tie. A tie occurs when the entire
 * board is full.
 * 
 * @returns {boolean} true if there is a tie, false otherwise
 */
function isATie() {
    // 1. find all icons
    const icons = document.querySelectorAll('i');
    // 2. if every one DOES, return true
    let isATie = true;
    icons.forEach((icon) => {
        if ( !(icon.classList.contains(player1.iconClass) || icon.classList.contains(player2.iconClass))) {
            isATie = false;
            return;
        }
    });
    return isATie;
}

/**
 * Record a win by increasing the current player's score on the UI.
 */
function recordWin() {
    // find p element that has win count based on current player
    // if (currentPlayer === player1) {
    //     const winCounterSection = document.querySelector('#score-player-1 > .score-text');
    //     const currentwins = Number.parseInt(winCounterSection.innerText);
    //     winCounterSection.innerText = currentwins + 1;
    // } else {
    //     const winCounterSection = document.querySelector('#score-player-1 > .score-text');
    //     const currentwins = Number.parseInt(winCounterSection.innerText);
    //     winCounterSection.innerText = currentwins + 1;
    // }

        const winCounterSection = document.querySelector(currentPlayer.scoreClass);
        const currentwins = Number.parseInt(winCounterSection.innerText);
        winCounterSection.innerText = currentwins + 1;


    //increase count by one, get current number of wins, update by increasing
}

/**
 * Record a win by increasing the number of ties on the UI.
 */
function recordTie() {
    // find p element that has the ties count
    const scoreTiesSection = document.querySelector('#score-ties > p');

    //increase count by one - get current number of ties, update by increasing by one
    const currentTies = Number.parseInt(scoreTiesSection.innerText);
    scoreTiesSection.innerText = currentTies + 1;
}

function removeAllTileClickEvents() {
    //find every tile
    const allTiles = document.querySelectorAll('.tile');

    //remove event listeners
    allTiles.forEach((tile) => {
        tile.removeEventListener('click', onTileClicked);
    })
}

function onTileClicked(e) {
    const tileClicked = e.currentTarget;
    recordMove(tileClicked);
    tileClicked.removeEventListener('click', onTileClicked); // don't respond to future click events for this tile

    if (isAWin()) {
        recordWin();
        //we need to stop the ability to click things once a win happens
        removeAllTileClickEvents();
        return;
    }

    if (isATie()) {
        recordTie();
        return;
    }

    switchPlayer();
}


/**
 * Remove all player icons from the board.
 */
function removeAllIcons() {
    // find icons
    const icons = document.querySelectorAll('i');

    //remove fa-times and fa-circle from each icon
    icons.forEach(icon => {
        icon.classList.remove(player1.iconClass);
        icon.classList.remove(player2.iconClass);
    });
}

function addTileClickListeners() {
    const tiles = document.querySelectorAll('.tile');

    tiles.forEach(t => {
        t.removeEventListener('click', onTileClicked);
        t.addEventListener('click', onTileClicked);
    });
}

function onPlayAgainClicked() {
    removeAllIcons();
    switchPlayer();
    addTileClickListeners();
}


document.addEventListener('DOMContentLoaded', () => {
    addTileClickListeners();

    const btn = document.getElementById('btn-play-again');
    btn.addEventListener('click', onPlayAgainClicked);
});