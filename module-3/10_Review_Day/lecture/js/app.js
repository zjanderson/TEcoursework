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
    // TODO
}

/**
 * Returns true if the current player has won. A win can
 * be three in a row horizontally, vertically, or diagonally.
 * 
 * @returns {boolean} true if the current player has won, false otherwise
 */
function isAWin() {
    // TODO
    return false;
}

/**
 * Returns true if there is a tie. A tie occurs when the entire
 * board is full.
 * 
 * @returns {boolean} true if there is a tie, false otherwise
 */
function isATie() {
    // TODO
    return false;
}

/**
 * Record a win by increasing the current player's score on the UI.
 */
function recordWin() {
    // TODO
}

/**
 * Record a win by increasing the number of ties on the UI.
 */
function recordTie() {
    // TODO
}

function onTileClicked(e) {
    const tileClicked = e.currentTarget;
    recordMove(tileClicked);
    tileClicked.removeEventListener('click', onTileClicked); // don't respond to future click events for this tile

    if (isAWin()) {
        recordWin();
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
    // TODO
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