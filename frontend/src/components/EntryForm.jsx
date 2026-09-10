import { useState } from 'react';

function EntryForm({ onSubmit }) {
  const [title, setTitle] = useState('');
  const [lengthMinutes, setLengthMinutes] = useState('');

  function handleSubmit(event) {
    event.preventDefault();
    onSubmit?.({ title, lengthMinutes: Number(lengthMinutes) || null });
    setTitle('');
    setLengthMinutes('');
  }

  return (
    <form onSubmit={handleSubmit}>
      <input
        value={title}
        onChange={(e) => setTitle(e.target.value)}
        placeholder="Titel"
        required
      />
      <input
        value={lengthMinutes}
        onChange={(e) => setLengthMinutes(e.target.value)}
        placeholder="Länge (Minuten)"
        type="number"
      />
      <button type="submit">Hinzufügen</button>
    </form>
  );
}

export default EntryForm;
