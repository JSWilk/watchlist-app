function WatchlistEntry({ entry, onToggleWatched }) {
  return (
    <li>
      <span>{entry.title}</span>
      {entry.lengthMinutes ? <span> ({entry.lengthMinutes} min)</span> : null}
      <label>
        <input
          type="checkbox"
          checked={entry.watched}
          onChange={() => onToggleWatched?.(entry.id)}
        />
        gesehen
      </label>
    </li>
  );
}

export default WatchlistEntry;
